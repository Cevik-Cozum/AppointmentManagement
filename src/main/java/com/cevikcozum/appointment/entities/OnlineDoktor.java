package com.cevikcozum.appointment.entities;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity(name = "onlinedoktor")
@Table(name = "onlinedoktor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnlineDoktor {


    @Id
    @Column(name = "doctor_online_date_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @Column(name = "finish_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime finishDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id") 
    private Doktor doktor;

    @JoinColumn(name = "isEmpty") 
    private Boolean isEmpty;


    
}
