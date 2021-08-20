package com.example.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.entities.*;
import com.example.springboot.pojos.HastaneRequest;
import com.example.springboot.services.*;
import java.util.List;

@RestController
public class HomeController {
    

    @Autowired
    DepartmanService departmanService;

    @Autowired
    HastaneService hastaneService;

    @Autowired DoktorService doktorService;

    @GetMapping("sayhello")
    public String sayHello(){
        return "Hello errran";
    }

    @GetMapping("departmans")
    public List<Departman> getDepartman(){
        return departmanService.getDepartman();
    }

   

 

    // @PostMapping("adddepartman")
    // public Departman SaveDepartman(@RequestBody Departman departman){
    //     return departmanService.saveDepartman(departman);
    // }

    @GetMapping("getdepartman")
    public Departman getDepartman(String departmanname){
        return departmanService.getDepartman(departmanname);
    }

    @PostMapping("addhastane")
    public Hastane addHastane(@RequestBody HastaneRequest hastaneRequest){
        return hastaneService.addHastaneWithDepartman(hastaneRequest);
    }

    @GetMapping("hospitals")
    public List<Hastane> getHastane(){
        return hastaneService.getHastane();
    }   

    @GetMapping("doctors")
    public List<Doktor> getDoktor(){
        return doktorService.getDoktor();
    }

    @GetMapping("doctors/{id}")
    public Doktor getDoktor(@PathVariable int id){
        return doktorService.getDoktorId(id);
    }

    @GetMapping("hospitals/{id}")
    public Hastane getHastane(@PathVariable int id){
        return hastaneService.getHastaneId(id);
    }

    @GetMapping("departmans/{id}")
    public Departman getDepartman(@PathVariable int id){
        return departmanService.getDepartmanId(id);
    }
     
}

