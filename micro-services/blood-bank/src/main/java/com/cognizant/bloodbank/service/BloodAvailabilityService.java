package com.cognizant.bloodbank.service;

import java.util.Set;

import com.cognizant.bloodbank.DTO.AdminAvailabiltyDTO;
import com.cognizant.bloodbank.model.BloodAvailability;

public interface BloodAvailabilityService {
	public BloodAvailability insertNewDonor(BloodAvailability bloodAvailability);
	public Set<BloodAvailability> getAllBloodAvailability(String bloodGroup, String state, String area,long pincode);
	public Set<AdminAvailabiltyDTO> getAllBloodAvailabilityToAdmin();
}
