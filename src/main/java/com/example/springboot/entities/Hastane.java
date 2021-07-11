package com.example.springboot.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "hastane")
public class Hastane {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private int id;

    @Column(name = "name")
    private String hospitalName;


    @ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "hastane_departman",
    joinColumns = @JoinColumn(name="hospital_id"),
    inverseJoinColumns = @JoinColumn(name="department_id"))
    @JsonIgnore
    private Set<Departman> departs=new HashSet<>();
    
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "hospital_id")
    private Set<Doktor> doktors;

    public Hastane(){

    }

    public Set<Doktor> getDoktors() {
        return doktors;
    }

    public void setDoktors(Set<Doktor> doktors) {
        this.doktors = doktors;
    }

    public Hastane(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Set<Departman> getDeparts() {
        return departs;
    }

    public void setDeparts(Set<Departman> departs) {
        this.departs = departs;
    }




    
}
