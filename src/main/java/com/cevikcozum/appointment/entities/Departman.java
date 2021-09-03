package com.cevikcozum.appointment.entities;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "departman")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departman {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonIgnore // İD ALANINI GÖSTERMEZ JSON FORMATINDA
    private int id;

    @Column(name = "name")
    private String departmanName;

    
    @ManyToMany(mappedBy = "departs")
    @JsonIgnore
    private Set<Hastane> hospitals = new HashSet<>();

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "department_id")
    private Set<Doktor> doktors;

    

    public void addHastane(Hastane hospital) {
        this.hospitals.add(hospital);
    }


}
