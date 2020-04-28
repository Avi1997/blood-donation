package com.cognizant.bloodbank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.BloodRequirement;
import com.cognizant.bloodbank.repository.BloodRequirementPostingRepository;

@Service()
public class BloodRequirementServiceImpl implements BloodRequirementService {

	@Autowired
	BloodRequirementPostingRepository bloodRequirementPostingRepository;

	@Transactional
	public BloodRequirement insertRequirement(BloodRequirement bloodRequirement) {
		
		return this.bloodRequirementPostingRepository.save(bloodRequirement);
	}

	@Transactional
	public List<BloodRequirement> getAllBloodRequireMent() {
		return this.bloodRequirementPostingRepository.findAll();
	}

}
