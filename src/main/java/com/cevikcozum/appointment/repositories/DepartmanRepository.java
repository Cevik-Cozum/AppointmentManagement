package com.cevikcozum.appointment.repositories;
import com.cevikcozum.appointment.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmanRepository extends JpaRepository<Departman,Integer>{
    
    Departman findByDepartmanName(String departmanname);
    public Departman findById(int id);
}
