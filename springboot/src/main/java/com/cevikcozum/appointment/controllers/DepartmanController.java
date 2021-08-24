package com.cevikcozum.appointment.controllers;

import java.util.List;

import com.cevikcozum.appointment.entities.Departman;
import com.cevikcozum.appointment.services.DepartmanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class DepartmanController {
    
    @Autowired
    DepartmanService departmanService;

    @GetMapping("departmans")
    public List<Departman> getDepartman(){
        return departmanService.getDepartman();
    }
    
    @GetMapping("departmans/{id}")
    public Departman getDepartman(@PathVariable int id){
        return departmanService.getDepartmanId(id);
    }


    // @PostMapping("adddepartman")
    // public Departman SaveDepartman(@RequestBody Departman departman){
    //     return departmanService.saveDepartman(departman);
    // }

    @GetMapping("getdepartman")
    public Departman getDepartman(String departmanname){
        return departmanService.getDepartman(departmanname);
    }

}
