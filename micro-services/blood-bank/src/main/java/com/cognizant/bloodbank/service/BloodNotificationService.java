package com.cognizant.bloodbank.service;

import java.util.Set;

import com.cognizant.bloodbank.DTO.BloodNotificationDto;


public interface BloodNotificationService {
	public Set<BloodNotificationDto> getAllNotification(String username);
	public Set<BloodNotificationDto> getAllNotificationHistory(String username);
	public void removeNotificationById(int id);
	public void removeNotification(String username);
	public void updateNotificationStatus(int notificationId);
	public void postBloodDonationNotificationThreeMonth(String username);
	public void postBloodDonationNotificationBloodGroup(String bloodGroup);
	
}
