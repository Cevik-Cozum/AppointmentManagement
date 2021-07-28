package com.cevikcozum.appointment.repositories;
import com.cevikcozum.appointment.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineDoktorRepository extends JpaRepository<OnlineDoktor,Integer>{
    
   
    public OnlineDoktor findById(int id);
}
