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

import com.cognizant.bloodbank.DTO.DonorExperienceDTO;
import com.cognizant.bloodbank.service.DonorExperienceService;




@RestController
@RequestMapping("/blood-bank")
public class DonorExperienceController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DonorExperienceController.class);

	@Autowired
	DonorExperienceService donorExperienceService;

	@GetMapping("/get-feedback")
	public List<DonorExperienceDTO> getAllDonorExperience() {
		LOGGER.info("START->END");
		return this.donorExperienceService.getAllDonorExperience();
	}
	
	@PostMapping("/put-feedback")
	public boolean postBloodRequirement(@RequestBody @Valid DonorExperienceDTO userExperienceDTO) {
		LOGGER.info("START->END");
		return this.donorExperienceService.postDonorExperience(userExperienceDTO);
	}

}