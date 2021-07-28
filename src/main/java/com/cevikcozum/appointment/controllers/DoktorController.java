package com.cevikcozum.appointment.controllers;

import java.util.List;

import com.cevikcozum.appointment.entities.Doktor;
import com.cevikcozum.appointment.services.DoktorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoktorController {
    
    
    @Autowired 
    DoktorService doktorService;

    @GetMapping("doctors")
    public List<Doktor> getDoktor(){
        return doktorService.getDoktor();
    }

    @GetMapping("doctors/{id}")
    public Doktor getDoktor(@PathVariable int id){
        return doktorService.getDoktorId(id);
    }
}
