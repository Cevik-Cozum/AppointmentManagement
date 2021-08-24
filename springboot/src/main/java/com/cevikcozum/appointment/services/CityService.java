package com.cevikcozum.appointment.services;

import com.cevikcozum.appointment.entities.City;
import com.cevikcozum.appointment.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityService {
    @Autowired CityRepository cityRepository;


  
    public CityService(){}


    public List<City> getCity(){
        return cityRepository.findAll();
    }
 
}