package com.cevikcozum.appointment.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.cevikcozum.appointment.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineDoktorRepository extends JpaRepository<OnlineDoktor,Integer>{
    
    public OnlineDoktor findById(int id);
    public OnlineDoktor getById(OnlineDoktor doktor);

    // @Query(value = " SELECT * FROM onlinedoktor WHERE doctor_id=15",nativeQuery = true)
    // public List<OnlineDoktor> getFindAll();

    // @Query(value = " SELECT * FROM onlinedoktor  WHERE start_date=? and doctor_id =?",nativeQuery = true)
    
    @Query(value = "SELECT * FROM onlinedoktor WHERE start_date >= ? and finish_date < ? and doctor_id=? and is_empty=true ",nativeQuery = true)
    public List<OnlineDoktor> getFindAll(@Param("startDate") LocalDate startDate,@Param("finishDate") LocalDate finishDate,@Param("id") Doktor doktor);


}
