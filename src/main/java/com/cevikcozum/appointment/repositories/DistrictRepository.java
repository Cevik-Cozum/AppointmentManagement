package com.cevikcozum.appointment.repositories;

import java.util.List;

import com.cevikcozum.appointment.entities.City;
import com.cevikcozum.appointment.entities.District;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DistrictRepository extends JpaRepository<District,Integer> {

    public District findById(int districtid);
    
    @Query(value = "SELECT * FROM district  WHERE cityid =? and name= ?",nativeQuery = true)
    public List<District> getFindAllFiltre(@Param("id") City cityid,@Param("districtName") String districtName);
}
