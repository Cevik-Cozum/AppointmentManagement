package com.cevikcozum.appointment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.cevikcozum.appointment.entities.*;
import com.cevikcozum.appointment.repositories.*;

@Service

public class DoktorService {

    @Autowired DoktorRepository doktorRepository;

    public DoktorService(){}

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
