package com.cevikcozum.appointment.repositories;

import com.cevikcozum.appointment.entities.Hastane;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HastaneRepository extends JpaRepository<Hastane,Integer> {

    public Hastane findById(Long id);
    
}
