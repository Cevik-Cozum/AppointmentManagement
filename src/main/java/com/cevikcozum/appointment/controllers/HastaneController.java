package com.cevikcozum.appointment.controllers;
import java.util.List;

import com.cevikcozum.appointment.entities.Hastane;
import com.cevikcozum.appointment.model.HospitalViewModel;
import com.cevikcozum.appointment.services.HastaneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HastaneController {
    
    @Autowired
    HastaneService hastaneService;

    @PostMapping("addhastane")
    public Hastane addHastane(@RequestBody HospitalViewModel hospitalViewModel){
        return hastaneService.addHastaneWithDepartman(hospitalViewModel);
    }

    @GetMapping("hospitals")
    public List<Hastane> getHastane(){
        return hastaneService.getHastane();
    }   

    @GetMapping("hospitals/{id}")
    public Hastane getHastane(@PathVariable int id){
        return hastaneService.getHastaneId(id);
    }

}
