package com.cevikcozum.appointment.controllers;

import java.util.List;

import com.cevikcozum.appointment.entities.Departman;
import com.cevikcozum.appointment.entities.Doktor;
import com.cevikcozum.appointment.entities.Hastane;
import com.cevikcozum.appointment.repositories.DepartmanRepository;
import com.cevikcozum.appointment.repositories.DoktorRepository;
import com.cevikcozum.appointment.repositories.HastaneRepository;
import com.cevikcozum.appointment.services.DoktorService;

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

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class DoktorController {
    
    
    @Autowired 
    DoktorService doktorService;

    @Autowired
    DepartmanRepository departmanRepository;

    @Autowired
    HastaneRepository hastaneRepository;

    @Autowired
    DoktorRepository doktorRepository;

    @GetMapping("doctors")
    public List<Doktor> getDoktor(){
        return doktorService.getDoktor();
    }

    @GetMapping("doctors/{id}")
    public Doktor getDoktor(@PathVariable int id){
        return doktorService.getDoktorId(id);
    }
    @PostMapping("doktorcreate/{department_id}/{hospital_id}")
    public void createDoktor(@RequestBody Doktor doktor,@PathVariable int department_id,@PathVariable int hospital_id) {
        
        Departman departman=departmanRepository.getById(department_id);
        Hastane hastane=hastaneRepository.getById(hospital_id);
        doktor.setHastane(hastane);
        doktor.setDepartman(departman);
        doktorRepository.save(doktor);
        System.out.print("------------------"+doktor);
  
    }
    @PutMapping("updateDoktor/{id}")
    public ResponseEntity<Doktor> updateDoktor(@PathVariable int id,@RequestBody Doktor doktor){
        Doktor result =doktorRepository.getById(id);
        result.setId(id);
        result.setDoktorName(doktor.getDoktorName());
        final Doktor updatedDoktor= doktorRepository.save(result);
        return ResponseEntity.ok(updatedDoktor);
    }
    @DeleteMapping("deleteDoktor/{id}")
    public ResponseEntity<?> deleteDoktor(@PathVariable Integer id) {
        // Doktor doktor=doktorRepository.getById(id);
        // doktor.setDepartman(null);
        // doktor.setHastane(null);
        doktorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
