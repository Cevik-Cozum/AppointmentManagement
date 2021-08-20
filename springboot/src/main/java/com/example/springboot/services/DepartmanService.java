package com.example.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.repositories.*;
import com.example.springboot.entities.*;
import java.util.List;

@Service
public class DepartmanService {

    @Autowired DepartmanRepository departmanRepository;
    
   

    public List<Departman> getDepartman(){
        return departmanRepository.findAll();
    }

    public Departman getDepartmanId(Integer id){
        Departman departman=departmanRepository.findAll().stream()
        .filter(t -> id.equals(t.getId()))
        .findFirst()
        .orElse(null);
        
        return departman;
    }

    

    public Departman saveDepartman(Departman departman) {
        return departmanRepository.save(departman);
    }

    public Departman getDepartman(String departmanname) {
        return departmanRepository.findByDepartmanName(departmanname);
    }
}
