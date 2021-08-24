package com.cevikcozum.appointment.services;
import com.cevikcozum.appointment.entities.City;
import com.cevikcozum.appointment.entities.District;
import com.cevikcozum.appointment.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DistrictService {
    @Autowired DistrictRepository districtRepository;


  
    public DistrictService(){}


    public List<District> getDistrict(){
        return districtRepository.findAll();
    }
    
    public List<District> getDistrictFiltre(City cityid,String districtName){
        return districtRepository.getFindAllFiltre(cityid,districtName);
    }
}  
