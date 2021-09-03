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
@Table(name = "district")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "districtid")
    private int districtid;

    @Column(name = "name")
    private String districtName; 

   
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cityid")
    private City cityid;


    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "neighborhoodid")
    private Set<Neighborhood> neighborhoods;



    
}
