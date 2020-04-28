package com.cognizant.bloodbank.service;

import java.util.List;

import com.cognizant.bloodbank.DTO.DonorExperienceDTO;



public interface DonorExperienceService {
public boolean postDonorExperience(DonorExperienceDTO DonorExperienceDTO);
	
	public List<DonorExperienceDTO> getAllDonorExperience();

}
