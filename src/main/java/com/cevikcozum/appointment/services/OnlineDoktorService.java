package com.cevikcozum.appointment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.cevikcozum.appointment.entities.*;
import com.cevikcozum.appointment.repositories.*;

@Service
public class OnlineDoktorService {

    @Autowired OnlineDoktorRepository onlineDoktorRepository;

    public List<OnlineDoktor> getOnlineDoktor(){
        return onlineDoktorRepository.findAll();
    }

    public List<OnlineDoktor> getOnlineDoktorFiltre(CharSequence startDate,CharSequence finishDate,Doktor doktor){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formattedDate2 = LocalDate.parse(startDate, formatter);
        LocalDate formattedDate3 = LocalDate.parse(finishDate, formatter);
        return onlineDoktorRepository.getFindAll(formattedDate2,formattedDate3,doktor);
    }

 

    public OnlineDoktor getOnlineDoktorId(Integer id){
        OnlineDoktor onlineDoktor=onlineDoktorRepository.findAll().stream()
        .filter(t -> id.equals(t.getId()))
        .findFirst()
        .orElse(null);
        
        return onlineDoktor;
    }

 
}
