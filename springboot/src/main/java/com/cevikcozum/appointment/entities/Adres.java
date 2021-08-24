package com.cevikcozum.appointment.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adres {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressid")
    private int addressid;

    @Column(name = "name")
    private String addressName; 

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "neighborhood_id")
    private Neighborhood  neighborhoodid;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "addressid")
    private Set<Hastane> hospitals;

    


    
}
