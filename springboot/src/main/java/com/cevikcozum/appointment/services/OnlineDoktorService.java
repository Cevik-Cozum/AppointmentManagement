package com.cevikcozum.appointment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.cevikcozum.appointment.entities.*;
import com.cevikcozum.appointment.repositories.*;

@Service
public class OnlineDoktorService {

    @Autowired OnlineDoktorRepository onlineDoktorRepository;

    public List<OnlineDoktor> getOnlineDoktor(){
        return onlineDoktorRepository.findAll();
    }

    public List<OnlineDoktor> getOnlineDoktorFiltre(LocalDateTime startDate,Doktor doktor){
        return onlineDoktorRepository.getFindAll(startDate,doktor);
    }

 

    public OnlineDoktor getOnlineDoktorId(Integer id){
        OnlineDoktor onlineDoktor=onlineDoktorRepository.findAll().stream()
        .filter(t -> id.equals(t.getId()))
        .findFirst()
        .orElse(null);
        
        return onlineDoktor;
    }

 
}
