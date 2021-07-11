package com.example.springboot.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entities.*;

@Repository
public interface DepartmanRepository extends JpaRepository<Departman,Integer>{
    
    Departman findByDepartmanName(String departmanname);
    public Departman findById(int id);
}
