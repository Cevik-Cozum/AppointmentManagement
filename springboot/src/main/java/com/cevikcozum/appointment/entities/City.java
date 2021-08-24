package com.cevikcozum.appointment.entities;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "city")
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cityid")
    private int cityid;

    @Column(name = "name")
    private String cityName; 


    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "cityid")
    private Set<District> districts;

    


    
}
