package com.cevikcozum.appointment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import com.cevikcozum.appointment.entities.*;
import com.cevikcozum.appointment.repositories.AdresRepository;
import com.cevikcozum.appointment.repositories.DoktorRepository;
import com.cevikcozum.appointment.repositories.OnlineDoktorRepository;
import com.cevikcozum.appointment.repositories.RandevuRepository;
import com.cevikcozum.appointment.services.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class HomeController {
    

    @Autowired 
    RandevuService randevuService;

    @Autowired 
    OnlineDoktorService  onlineDoktorService;

    @Autowired
    AdresService adresService;

    @Autowired
    CityService cityService;

    @Autowired
    DistrictService districtService;

    @Autowired
    DoktorRepository doktorRepository;

    @Autowired
    OnlineDoktorRepository onlineDoktorRepository;

    @Autowired
    NeighborhoodService neighborhoodService;

    @Autowired
    AdresRepository adresRepository;

    @Autowired
    RandevuRepository randevuRepository;

    @GetMapping("onlinedoctors")
    public List<OnlineDoktor> getOnlineDoktor(){
        return onlineDoktorService.getOnlineDoktor();
    }
    
    @GetMapping("onlinedoctorsfiltre")
    public List<OnlineDoktor> getOnlineDoktorFiltre(CharSequence startDate,CharSequence finishDate,Doktor doktor){
        return onlineDoktorService.getOnlineDoktorFiltre(startDate,finishDate,doktor); 
    }


    @GetMapping("address")
    public List<Adres> getAdres(){
        return adresService.getAdres();
    }

    @GetMapping("citys")
    public List<City> getCity(){
        return cityService.getCity();
    }
   
    @GetMapping("districts")
    public List<District> getDistrict(){
        return districtService.getDistrict();
    }

    @GetMapping("districtsfiltre")
    public List<District> getDistrictFiltre(City cityid,String districtName){
        return districtService.getDistrictFiltre(cityid,districtName);
    }


    

    @GetMapping("neighborhoods")
    public List<Neighborhood> getNeighborhood(){
        return neighborhoodService.getNeighborhood();
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
    public Adres createAdres(@RequestBody Adres adres) {
        adresRepository.save(adres);
        return adres;
    }
    @PostMapping("onlinedoktorcreate/{id}")
    public void createOnlineDoktor(@RequestBody OnlineDoktor onlinedoktor,@PathVariable int id) {
        System.out.print("-----------------------------------------------------------------sdfsdfsdfdsf");
        Doktor doktor=doktorRepository.getById(id);
        onlinedoktor.setDoktor(doktor);
        onlineDoktorRepository.save(onlinedoktor);
        System.out.print("------------------"+onlinedoktor);
  
    }


    @DeleteMapping("deleteOnlineDoktor/{id}")
    public ResponseEntity<?> deleteOnlineDoktor(@PathVariable Integer id) {
        onlineDoktorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("updateOnlineDoktor/{id}")
    public ResponseEntity<OnlineDoktor> updateOnlineDoktor(@RequestBody OnlineDoktor onlineDoktor,@PathVariable int id){
        OnlineDoktor onlineDoktorResult=onlineDoktorRepository.getById(id);
        onlineDoktorResult.setStartDate(onlineDoktor.getStartDate());
        onlineDoktorResult.setFinishDate(onlineDoktor.getFinishDate());
        final OnlineDoktor updatedHastane= onlineDoktorRepository.save(onlineDoktorResult);
        return ResponseEntity.ok(updatedHastane);
    }
    @PutMapping("updateOnlineDoktorIsEmptyAppointment/{id}")
    public ResponseEntity<OnlineDoktor> updateOnlineDoktorIsEmptyAppointment(@RequestBody OnlineDoktor onlineDoktor,@PathVariable int id){
        OnlineDoktor onlineDoktorResult=onlineDoktorRepository.getById(id);
        onlineDoktorResult.setIsEmpty(onlineDoktor.getIsEmpty());
        final OnlineDoktor updatedHastane= onlineDoktorRepository.save(onlineDoktorResult);
        return ResponseEntity.ok(updatedHastane);
    }
    
    @PostMapping("createAppointment/{doctorOnlineDateid}")
    public void createAppointment(@RequestBody Randevular randevular,@PathVariable int doctorOnlineDateid) {
        
        OnlineDoktor onlineDoktor=onlineDoktorRepository.getById(doctorOnlineDateid);
        randevular.setOnlineDoktor(onlineDoktor);
        randevuRepository.save(randevular);  
    }
}

