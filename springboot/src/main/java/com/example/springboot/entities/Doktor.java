package com.example.springboot.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "doktor")
public class Doktor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonIgnore // İD ALANINI GÖSTERMEZ JSON FORMATINDA
    private int id;

 
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hastane hastane;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departman departman;



    public Departman getDepartman() {
        return departman;
    }


    public void setDepartman(Departman departman) {
        this.departman = departman;
    }


    public Hastane getHastane() {
        return hastane;
    }


    public void setHastane(Hastane hastane) {
        this.hastane = hastane;
    }


    @Column(name = "name")
    private String doktorName;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getDoktorName() {
        return doktorName;
    }


    public void setDoktorName(String doktorName) {
        this.doktorName = doktorName;
    }




 

}
