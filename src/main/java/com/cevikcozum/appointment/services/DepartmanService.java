package com.cevikcozum.appointment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import com.cevikcozum.appointment.entities.*;
import com.cevikcozum.appointment.repositories.*;

@Service
public class DepartmanService{

    @Autowired DepartmanRepository departmanRepository;
    
   

    public List<Departman> getDepartman(){
        return departmanRepository.findAll();
    }

    public Departman getDepartmanId(Integer id){
        Departman departman=departmanRepository.findAll().stream() // listeden tek eleman çekmemize yarar.
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
