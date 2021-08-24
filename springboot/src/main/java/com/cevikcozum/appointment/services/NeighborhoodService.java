package com.cevikcozum.appointment.services;
import com.cevikcozum.appointment.entities.Neighborhood;
import com.cevikcozum.appointment.repositories.NeighborhoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NeighborhoodService {
    @Autowired NeighborhoodRepository neighborhoodRepository;


  
    public NeighborhoodService(){}


    public List<Neighborhood> getNeighborhood(){
        return neighborhoodRepository.findAll();
    }

}
