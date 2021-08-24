package com.cevikcozum.appointment.model;

import java.util.Set;

import com.cevikcozum.appointment.entities.Departman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalViewModel {

    public int id;
    
    public String hospitalName;

    public Set<Departman> departman;

    
}
