package com.example.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.repositories.*;
import com.example.springboot.entities.*;
import java.util.List;

@Service
public class DoktorService {

    @Autowired DoktorRepository doktorRepository;
    
   

    public List<Doktor> getDoktor(){
        return doktorRepository.findAll();
    }

    public Doktor getDoktorId(Integer id){
        Doktor doktor=doktorRepository.findAll().stream()
        .filter(t -> id.equals(t.getId()))
        .findFirst()
        .orElse(null);
        
        return doktor;
    }

 
}
