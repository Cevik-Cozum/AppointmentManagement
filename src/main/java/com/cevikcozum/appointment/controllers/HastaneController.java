package com.cevikcozum.appointment.controllers;

import java.util.List;

import com.cevikcozum.appointment.entities.Adres;
import com.cevikcozum.appointment.entities.District;
import com.cevikcozum.appointment.entities.Hastane;
import com.cevikcozum.appointment.entities.Neighborhood;
import com.cevikcozum.appointment.repositories.AdresRepository;
import com.cevikcozum.appointment.repositories.DistrictRepository;
import com.cevikcozum.appointment.repositories.HastaneRepository;
import com.cevikcozum.appointment.repositories.NeighborhoodRepository;
import com.cevikcozum.appointment.services.HastaneService;

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
public class HastaneController {

    @Autowired
    HastaneService hastaneService;

    @Autowired
    HastaneRepository hastaneRepository;

    @Autowired
    AdresRepository adresRepository;

    @Autowired
    NeighborhoodRepository neighborhoodRepository;
    
    @Autowired
    DistrictRepository districtRepository;
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
        Hastane hastane=hastaneRepository.getById(id);
        hastane.setAddressid(null);
        hastaneRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("deleteAdres/{addressid}")
    public ResponseEntity<?> deleteHospital2(@PathVariable int addressid) {
        Adres adres=adresRepository.getById(addressid);
        adres.setNeighborhoodid(null);
        adresRepository.deleteById(addressid);
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
        // Adres adresResult=adresRepository.getById(addressid);
        // adresResult.setAddressName(adresResult.getAddressName());
        // result.setAddressid(adresResult);
        result.setId(id);
        result.setHospitalName(hastane.getHospitalName());
        final Hastane updatedHastane= hastaneRepository.save(result);
        return ResponseEntity.ok(updatedHastane);
    }
    @PutMapping("updateAdres/{addressid}")
    public ResponseEntity<Adres> updateEmployee(@RequestBody Adres adres,@PathVariable int addressid){
        Adres adresResult=adresRepository.getById(addressid);
        adresResult.setAddressName(adres.getAddressName());
        adresResult.setAddressid(addressid);
        final Adres updatedHastane= adresRepository.save(adresResult);
        return ResponseEntity.ok(updatedHastane);
    }
    @PostMapping("create/{addressid}/{neighborhoodid}/{districtid}")
    public void createHospital(@RequestBody Hastane hastane,@PathVariable int addressid,@PathVariable int neighborhoodid,@PathVariable int districtid) {
        
        Adres adres=adresRepository.getById(addressid);
        Neighborhood neighborhood=neighborhoodRepository.getById(neighborhoodid);
        District district=districtRepository.getById(districtid);
        neighborhood.setDistrictid(district);
        adres.setNeighborhoodid(neighborhood);
        hastane.setAddressid(adres);
        hastaneRepository.save(hastane);
        System.out.print("---------------------------"+hastane);
  
    }

}
