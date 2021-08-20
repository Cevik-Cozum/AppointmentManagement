package com.cevikcozum.appointment.repositories;

import com.cevikcozum.appointment.entities.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdresRepository extends JpaRepository<Adres,Integer> {

    public Adres findById(int addressid);
    
}
