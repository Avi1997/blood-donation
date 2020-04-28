package com.cognizant.bloodbank.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.DTO.AdminAvailabiltyDTO;
import com.cognizant.bloodbank.model.BloodAvailability;

@Repository
public interface BloodAvailablityRepository extends JpaRepository<BloodAvailability, Integer>{
	@Query(value = "select ba from BloodAvailability ba where ba.bloodGroup = ?1 and ba.state = ?2 and ba.area = ?3 and ba.pincode = ?4")
	public Set<BloodAvailability> getAllBloodAvailability(String bloodGroup, String state, String area,long pincode);

	@Query("SELECT new com.cognizant.bloodbank.DTO.AdminAvailabiltyDTO(BD.bloodGroup, COUNT(BD.id)) FROM BloodAvailability BD GROUP BY BD.bloodGroup")
	public Set<AdminAvailabiltyDTO> getAvailabilityToAdmin();
}
