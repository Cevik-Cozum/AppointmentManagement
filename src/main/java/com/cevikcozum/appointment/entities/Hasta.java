// package com.cevikcozum.appointment.entities;


// import java.util.Set;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;
// import javax.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;



// @Entity
// @Table(name = "hasta")
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Hasta {
    
//     @Id
//     @Column(name = "patient_id")
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;


//     @Column(name = "name")
//     private String hastaName;

//     @JsonIgnore
//     @OneToMany
//     @JoinColumn(name = "patient_id")
//     private Set<Randevular> randevular;

// }