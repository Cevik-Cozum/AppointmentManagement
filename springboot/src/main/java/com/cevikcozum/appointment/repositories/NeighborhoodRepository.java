package com.cevikcozum.appointment.repositories;

import com.cevikcozum.appointment.entities.Neighborhood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood,Integer> {

    public Neighborhood findById(int neighborhoodid);
    
}
