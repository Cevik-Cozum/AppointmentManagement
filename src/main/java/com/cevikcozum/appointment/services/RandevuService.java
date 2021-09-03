package com.cevikcozum.appointment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cevikcozum.appointment.entities.*;
import com.cevikcozum.appointment.repositories.*;

@Service
public class RandevuService {

    @Autowired RandevuRepository randevuRepository;

    public RandevuService(){}

    public List<Randevular> getRandevular(){
        return randevuRepository.findAll();
    }

    public Randevular getRandevularId(Integer id){
        Randevular randevu=randevuRepository.findAll().stream()
        .filter(t -> id.equals(t.getId()))
        .findFirst()
        .orElse(null);
        
        return randevu;
    }

 
}
