package com.cevikcozum.appointment.repositories;
import com.cevikcozum.appointment.entities.Randevular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RandevuRepository extends JpaRepository<Randevular,Integer>{
    
    
    public Randevular findById(int id);
}
