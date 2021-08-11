package com.cevikcozum.appointment.controllers;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.cevikcozum.appointment.entities.Adres;
import com.cevikcozum.appointment.entities.Hastane;
import com.cevikcozum.appointment.model.HospitalViewModel;
import com.cevikcozum.appointment.repositories.AdresRepository;
import com.cevikcozum.appointment.repositories.HastaneRepository;
import com.cevikcozum.appointment.services.HastaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class HastaneController {

    @Autowired
    HastaneService hastaneService;

    @Autowired
    HastaneRepository hastaneRepository;

    @Autowired
    AdresRepository adresRepository;

    // @PostMapping("addhastane")
    // public Hastane addHastane(@RequestBody HospitalViewModel hospitalViewModel){
    // return hastaneService.addHastaneWithDepartman(hospitalViewModel);


    @GetMapping("hospitals")
    public List<Hastane> getHastane() {
        return hastaneService.getHastane();
    }

    @GetMapping("hospitals/{id}")
    public Hastane getHastane(@PathVariable int id){
    return hastaneService.getHastaneId(id);
    }

    // @DeleteMapping("delete/{id}")
    // public void hospitalDelete(@PathVariable Integer id){
    // hastaneRepository.deleteById(id);
    // }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteHospital(@PathVariable Integer id) {
        hastaneRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    // @PutMapping("update")
    // public ResponseEntity<Hastane> updateHospital(@RequestBody Hastane hastane) {
    // Hastane result=hastaneRepository.save(hastane);
    // return ResponseEntity.ok().body(result);
    // }

    @PutMapping("update/{id}")
    public ResponseEntity<Hastane> updateEmployee(@PathVariable int id,@RequestBody Hastane hastane){
        Hastane result =hastaneRepository.getById(id);

        result.setId(id);
        result.setHospitalName(hastane.getHospitalName());
        final Hastane updatedHastane= hastaneRepository.save(result);
        return ResponseEntity.ok(updatedHastane);
    }

    @PostMapping("create")
    public void createHospital(@Validated @RequestBody Hastane hastane) {
        hastaneRepository.save(hastane);
       
        System.out.print("------------------"+hastane);
  
    }

}
