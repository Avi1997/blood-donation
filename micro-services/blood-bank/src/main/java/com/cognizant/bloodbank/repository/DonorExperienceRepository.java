package com.cognizant.bloodbank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.DonorExperience;

@Repository
public interface DonorExperienceRepository extends JpaRepository<DonorExperience, Integer> {

}