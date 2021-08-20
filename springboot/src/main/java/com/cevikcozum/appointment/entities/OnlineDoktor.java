package com.cevikcozum.appointment.entities;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "onlinedoktor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnlineDoktor {


    @Id
    @Column(name = "doctor_online_date_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "finish_date")
    private String finishDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doktor doktor;
    
}
