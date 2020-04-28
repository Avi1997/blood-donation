package com.cognizant.bloodbank.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.DTO.AdminAvailabiltyDTO;
import com.cognizant.bloodbank.model.BloodAvailability;
import com.cognizant.bloodbank.service.BloodAvailabilityService;

@RestController
@RequestMapping("/blood-bank")
public class BloodAvailablityController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodAvailablityController.class);
	@Autowired
	BloodAvailabilityService bloodAvailabilityService;
		
	@GetMapping("/{bloodGroup}/{state}/{area}/{pincode}")
	public Set<BloodAvailability> getAllBloodAvailability(@PathVariable String bloodGroup, @PathVariable String state, @PathVariable String area,@PathVariable long pincode) {
		LOGGER.info("START->END");
		return this.bloodAvailabilityService.getAllBloodAvailability(bloodGroup, state, area,pincode);
	}
	
	@GetMapping("/blood-count")
	 public Set<AdminAvailabiltyDTO> getAllAvailability(){
		LOGGER.info("Start -> End");
		 return this.bloodAvailabilityService.getAllBloodAvailabilityToAdmin();
	 }
	
}
