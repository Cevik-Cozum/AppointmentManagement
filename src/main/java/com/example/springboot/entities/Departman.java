package com.example.springboot.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "departman")
public class Departman {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore // İD ALANINI GÖSTERMEZ JSON FORMATINDA
    private int id;

    @Column(name = "name")
    private String departmanName;


    @ManyToMany(mappedBy = "departs")
    @JsonIgnore
    private Set<Hastane> hospitals=new HashSet<>();

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "department_id")
    private Set<Doktor> doktors;

    public Set<Doktor> getDoktors() {
        return doktors;
    }

    public void setDoktors(Set<Doktor> doktors) {
        this.doktors = doktors;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getDepartmanName(){
        return departmanName;
    }

    public void setDepartmanName(String departmanName){
        this.departmanName=departmanName;
    }
    public Set<Hastane> getHospitals() {
        return hospitals;
    }

    public void setHospitals(Set<Hastane> hospitals) {
        this.hospitals = hospitals;
    }
    public void addHospital(Hastane hastane){
        this.hospitals.add(hastane);
    }
    
 

}
