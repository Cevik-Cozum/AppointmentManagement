package com.cevikcozum.appointment.repositories;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.cevikcozum.appointment.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;



@Repository
public interface OnlineDoktorRepository extends JpaRepository<OnlineDoktor,Integer>{
    
    public OnlineDoktor findById(int id);
    public OnlineDoktor getById(OnlineDoktor doktor);

    // @Query(value = " SELECT * FROM onlinedoktor WHERE doctor_id=15",nativeQuery = true)
    // public List<OnlineDoktor> getFindAll();

    // @Query(value = "SELECT * FROM table WHERE start_date >= '2021-08-20'::date AND start_date < ('2021-08-20'::date + '1 day'::interval);",nativeQuery = true)
    @Query(value = " SELECT * FROM onlinedoktor  WHERE start_date='?' and doctor_id =?",nativeQuery = true)
    public List<OnlineDoktor> getFindAll(@Param(value = "startDate") LocalDateTime startDate,@Param("id") Doktor doktor);
}
