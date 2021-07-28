package com.cevikcozum.appointment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.cevikcozum.appointment.entities.*;
import com.cevikcozum.appointment.services.*;

@RestController
public class HomeController {
    

    

    @Autowired 
    RandevuService randevuService;

    @Autowired 
    OnlineDoktorService  onlineDoktorService;



   



    @GetMapping("onlinedoctors")
    public List<OnlineDoktor> getOnlineDoktor(){
        return onlineDoktorService.getOnlineDoktor();
    }

    @GetMapping("onlinedoctors/{id}")
    public OnlineDoktor getOnlineDoktor(@PathVariable int id){
        return onlineDoktorService.getOnlineDoktorId(id);
    }

    @GetMapping("appointments")
    public List<Randevular> getRandevular(){
        return randevuService.getRandevular();
    }

    
  
     
}

