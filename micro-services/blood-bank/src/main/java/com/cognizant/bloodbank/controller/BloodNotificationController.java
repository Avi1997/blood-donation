package com.cognizant.bloodbank.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.DTO.BloodNotificationDto;
import com.cognizant.bloodbank.service.BloodNotificationService;


@RestController
@RequestMapping("/blood-bank")
public class BloodNotificationController {
	
	@Autowired
	BloodNotificationService bloodNotificationService;
	
	
	@GetMapping("/notification/{username}")
	public Set<BloodNotificationDto> getAllNotification(@PathVariable String username){		
		return this.bloodNotificationService.getAllNotification(username);
	}
	
	@GetMapping("/notification-history/{username}")
	public Set<BloodNotificationDto> getNotificationHistory(@PathVariable String username){
		return this.bloodNotificationService.getAllNotificationHistory(username);
	}
	
	@DeleteMapping("/delete-notification-history/{id}")
	public void deleteNotificationById(@PathVariable int id) {
		this.bloodNotificationService.removeNotificationById(id);
	}
	
	@PutMapping("/update-notification/{notificationId}")
	public void markAsRead(@PathVariable int notificationId) {
		this.bloodNotificationService.updateNotificationStatus(notificationId);
	}
	
	@PostMapping("/three-month-notification/{username}")
	public void postBloodDonationNotification(@PathVariable String username) {
		this.bloodNotificationService.postBloodDonationNotificationThreeMonth(username);	
	}
	
	@PostMapping("/user-notification-with-bloodgroup/{bloodGroup}")
	public void postBloodDonationNotificationBloodGroup(@PathVariable String bloodGroup) {
		this.bloodNotificationService.postBloodDonationNotificationBloodGroup(bloodGroup);
	}
	
}
