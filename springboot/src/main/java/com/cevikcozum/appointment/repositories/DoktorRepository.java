package com.cevikcozum.appointment.repositories;
import com.cevikcozum.appointment.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoktorRepository extends JpaRepository<Doktor,Integer>{
    
    Doktor findByDoktorName(String doktorname);
    public Doktor findById(int id);
}
