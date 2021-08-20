package com.example.springboot.repositories;

import com.example.springboot.entities.Hastane;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HastaneRepository extends JpaRepository<Hastane,Integer> {

    public Hastane findById(int id);
    
}
