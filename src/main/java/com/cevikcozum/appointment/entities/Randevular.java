package com.cevikcozum.appointment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "randevular")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Randevular {

    @Id
    @Column(name = "appointment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore // İD ALANINI GÖSTERMEZ JSON FORMATINDA
    private int id;

    @Column(name = "appointment_date")
    private String appointment_date;

    @OneToOne
    @JoinColumn(name = "doctor_online_date_id")
    private OnlineDoktor onlineDoktor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Hasta hasta;

}
