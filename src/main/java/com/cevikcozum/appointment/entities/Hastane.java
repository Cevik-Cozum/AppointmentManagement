package com.cevikcozum.appointment.entities;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "hastane")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hastane {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private int id;

    @Column(name = "name")
    private String hospitalName; 

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid")
    private Adres addressid;


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
    
   

    
}
