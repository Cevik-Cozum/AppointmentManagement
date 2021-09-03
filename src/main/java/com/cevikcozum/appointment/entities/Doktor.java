package com.cevikcozum.appointment.entities;


import java.util.Set;

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


@Entity(name = "doktor")
@Table(name = "doktor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doktor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String doktorName;

 
    // @ManyToOne
    // @JoinColumn(name = "hospital_id")
    // private Hastane hastane;
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hastane hastane;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departman departman;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "doctor_id")
    private Set<OnlineDoktor> onlineDoktors;

}