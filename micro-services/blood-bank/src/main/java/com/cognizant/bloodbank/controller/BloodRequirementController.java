package com.cognizant.bloodbank.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.bloodbank.model.BloodRequirement;
import com.cognizant.bloodbank.service.BloodRequirementService;

@RestController
@RequestMapping("/blood-bank") 
public class BloodRequirementController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodRequirementController.class);

	@Autowired()
	BloodRequirementService bloodRequirementService;
	
	@PostMapping("/post-requirement") 
	public BloodRequirement insertRequirement(@Valid @RequestBody BloodRequirement bloodRequirement) {
		LOGGER.info("START->END");
		return bloodRequirementService.insertRequirement(bloodRequirement);
	}

	@GetMapping("/get-requirement")
	public List<BloodRequirement> getAllBloodRequireMent() {
		LOGGER.info("START->END");
		return bloodRequirementService.getAllBloodRequireMent();
	}
}
