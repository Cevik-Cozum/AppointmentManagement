package com.example.springboot.services;

import java.util.stream.Collectors;

import com.example.springboot.entities.Departman;
import com.example.springboot.entities.Hastane;
import com.example.springboot.pojos.HastaneRequest;
import com.example.springboot.repositories.DepartmanRepository;
import com.example.springboot.repositories.HastaneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HastaneService {
    @Autowired HastaneRepository hastaneRepository;

    @Autowired
    DepartmanRepository departmanRepository;

  
    public HastaneService(){}

    public List<Hastane> getHastane(){
        return hastaneRepository.findAll();
    }

    public Hastane getHastaneId(Integer id){
        Hastane hastane=hastaneRepository.findAll().stream()
        .filter(t -> id.equals(t.getId()))
        .findFirst()
        .orElse(null);
        
        return hastane;
    }
    
    public Hastane addHastaneWithDepartman(HastaneRequest hastaneRequest){
        Hastane hastane=new Hastane();
        hastane.setId(hastaneRequest.id);
        hastane.setHospitalName(hastaneRequest.hospitalName);
        hastane.setDeparts(hastaneRequest.departman
        .stream()
        .map(depart->{
            Departman ddeparts=depart;
            if(ddeparts.getId()>0){
                ddeparts=departmanRepository.findById(ddeparts.getId());
            }
            ddeparts.addHospital(hastane);
            return ddeparts;
        })
        .collect(Collectors.toSet()));
        return hastaneRepository.save(hastane);
    }

    
}
