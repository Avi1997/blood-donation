package com.cognizant.bloodbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.DTO.SlotBookingDTO;
import com.cognizant.bloodbank.service.HospitalBookingService;

@RestController
@RequestMapping("/blood-bank") 
public class BloodDonationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodDonationController.class);
	@Autowired
	HospitalBookingService hospitalBookingService;
	
	@PostMapping("/donate/{username}")
	public void addDonor(@RequestBody SlotBookingDTO slotBookingDTO,@PathVariable String username) {
		LOGGER.info("START");
		hospitalBookingService.addTimeSlot(slotBookingDTO,username);
		LOGGER.info("END");
	}
}
