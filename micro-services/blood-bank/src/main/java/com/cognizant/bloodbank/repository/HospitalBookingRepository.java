package com.cognizant.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.Hospital;
@Repository()
public interface HospitalBookingRepository extends JpaRepository<Hospital,Integer> {
	@Query(value = "select COUNT(ho_id) from hospital where ho_hospital_name=?1 and ho_city = ?2 ",nativeQuery = true)
	public int checkHospital(String hospitalName, String area);
	
	public Hospital findByHospitalNameAndCity(String name, String city);
}
