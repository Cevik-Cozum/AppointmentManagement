package com.cevikcozum.appointment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.cevikcozum.appointment.entities.*;
import com.cevikcozum.appointment.repositories.AdresRepository;
import com.cevikcozum.appointment.services.*;

@RestController
public class HomeController {
    

    @Autowired 
    RandevuService randevuService;

    @Autowired 
    OnlineDoktorService  onlineDoktorService;

    @Autowired
    AdresService adresService;

    @Autowired
    AdresRepository adresRepository;

    @GetMapping("onlinedoctors")
    public List<OnlineDoktor> getOnlineDoktor(){
        return onlineDoktorService.getOnlineDoktor();
    }

    @GetMapping("address")
    public List<Adres> getAdres(){
        return adresService.getAdres();
    }

    @GetMapping("onlinedoctors/{id}")
    public OnlineDoktor getOnlineDoktor(@PathVariable int id){
        return onlineDoktorService.getOnlineDoktorId(id);
    }

    @GetMapping("appointments")
    public List<Randevular> getRandevular(){
        return randevuService.getRandevular();
    }
    
    @PostMapping("adrescreate")
    public void createAdres(@RequestBody Adres adres) {
        adresRepository.save(adres);
    }
}

