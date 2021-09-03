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
@Table(name = "neighborhood")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neighborhood {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "neighborhoodid")
    private int neighborhoodid;

    @Column(name = "name")
    private String neighborhoodName; 

        
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    private District districtid;
    
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "addressid")
    private Set<Adres> adress;

    
    

    
}
