package com.cevikcozum.appointment.services;


import com.cevikcozum.appointment.entities.Adres;
import com.cevikcozum.appointment.repositories.AdresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdresService {
    @Autowired AdresRepository adresRepository;


  
    public AdresService(){}


    public List<Adres> getAdres(){
        return adresRepository.findAll();
    }

    // public Hastane getHastaneId(Integer id){
    //     Hastane hastane=hastaneRepository.findAll().stream()
    //     .filter(t -> id.equals(t.getId()))
    //     .findFirst()
    //     .orElse(null);
        
    //     return hastane;
    // }
    
    // public Hastane addHastaneWithDepartman(HospitalViewModel hospitalViewModel){
    //     Hastane hastane=new Hastane();
    //     hastane.setId(hospitalViewModel.id);
    //     hastane.setHospitalName(hospitalViewModel.hospitalName);
    //     hastane.setDeparts(hospitalViewModel.departman
    //     .stream()
    //     .map(depart->{
    //         Departman ddeparts=depart;
    //         if(ddeparts.getId()>0){
    //             ddeparts=departmanRepository.findById(ddeparts.getId());
    //         }
    //         ddeparts.addHastane(hastane);
    //         return ddeparts;
    //     })
    //     .collect(Collectors.toSet()));
    //     return hastaneRepository.save(hastane);
    // }

    
}
