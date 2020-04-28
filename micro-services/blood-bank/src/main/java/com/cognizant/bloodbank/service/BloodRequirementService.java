package com.cognizant.bloodbank.service;

import java.util.List;

import com.cognizant.bloodbank.model.BloodRequirement;

public interface BloodRequirementService {
	public BloodRequirement insertRequirement(BloodRequirement bloodRequirement);
	public List<BloodRequirement> getAllBloodRequireMent();
	
}
