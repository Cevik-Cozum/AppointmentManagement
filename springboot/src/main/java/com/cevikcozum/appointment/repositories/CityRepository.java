package com.cevikcozum.appointment.repositories;

import com.cevikcozum.appointment.entities.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    public City findById(int cityid);
    
}
