package com.cevikcozum.appointment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.cevikcozum.appointment.entities.*;
import com.cevikcozum.appointment.repositories.*;

@Service
public class OnlineDoktorService {

    @Autowired OnlineDoktorRepository onlineDoktorRepository;
    
   

    public List<OnlineDoktor> getOnlineDoktor(){
        return onlineDoktorRepository.findAll();
    }

    public OnlineDoktor getOnlineDoktorId(Integer id){
        OnlineDoktor onlineDoktor=onlineDoktorRepository.findAll().stream()
        .filter(t -> id.equals(t.getId()))
        .findFirst()
        .orElse(null);
        
        return onlineDoktor;
    }

 
}
