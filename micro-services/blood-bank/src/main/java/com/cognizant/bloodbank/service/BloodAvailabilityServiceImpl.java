package com.cognizant.bloodbank.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.DTO.AdminAvailabiltyDTO;
import com.cognizant.bloodbank.exception.NoBloodGroupAvailable;
import com.cognizant.bloodbank.model.BloodAvailability;
import com.cognizant.bloodbank.repository.BloodAvailablityRepository;

@Service()
public class BloodAvailabilityServiceImpl implements BloodAvailabilityService  {
	@Autowired
	BloodAvailablityRepository bloodAvailablityRepository;
	@Transactional
	@Override
	public BloodAvailability insertNewDonor(BloodAvailability bloodAvailability) {
		return bloodAvailablityRepository.save(bloodAvailability);
	}
	@Override
	@Transactional
	public Set<BloodAvailability> getAllBloodAvailability(String bloodGroup, String state, String area,long pincode) {
		Set<BloodAvailability> bloodList = bloodAvailablityRepository.getAllBloodAvailability(bloodGroup, state, area,pincode);
		if(bloodList.size() == 0) {
			throw new NoBloodGroupAvailable();
		}
		return bloodList;
	}
	@Override
	public Set<AdminAvailabiltyDTO> getAllBloodAvailabilityToAdmin() {
		return bloodAvailablityRepository.getAvailabilityToAdmin();
	}
}
