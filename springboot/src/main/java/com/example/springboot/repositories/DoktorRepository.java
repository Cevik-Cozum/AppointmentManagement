package com.example.springboot.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entities.*;

@Repository
public interface DoktorRepository extends JpaRepository<Doktor,Integer>{
    
    Doktor findByDoktorName(String doktorname);
    public Doktor findById(int id);
}
