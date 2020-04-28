package com.cognizant.bloodbank.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.bloodbank.DTO.BloodNotificationDto;
import com.cognizant.bloodbank.model.BloodDonor;
import com.cognizant.bloodbank.model.BloodNotification;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.BloodDonorRepository;
import com.cognizant.bloodbank.repository.BloodNotificationRepository;
import com.cognizant.bloodbank.repository.UserRepository;

@Service
public class BloodNotificationServiceImpl implements BloodNotificationService{
	
	@Autowired
	BloodNotificationRepository bloodNotificationRepository;
	
	@Autowired
	BloodDonorRepository bloodDonorRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Override
	public Set<BloodNotificationDto> getAllNotification(String username){
		Set<BloodNotification> bloodNotificationSet =  this.bloodNotificationRepository.getAllNotification(username);
		Set<BloodNotificationDto> bloodNotificationDtoSet = new HashSet<BloodNotificationDto>();
		for(BloodNotification temp:bloodNotificationSet) {
			BloodNotificationDto dto = new BloodNotificationDto(temp.getId(), temp.getNotification(), temp.isStatus(), temp.getUser().getUsername());
			bloodNotificationDtoSet.add(dto);
		}
		return bloodNotificationDtoSet;
	}

	@Override
	public Set<BloodNotificationDto> getAllNotificationHistory(String username) {
		Set<BloodNotification> bloodNotificationSet =  this.bloodNotificationRepository.getAllNotificationHistory(username);
		Set<BloodNotificationDto> bloodNotificationDtoSet = new HashSet<BloodNotificationDto>();
		for(BloodNotification temp:bloodNotificationSet) {
			BloodNotificationDto dto = new BloodNotificationDto(temp.getId(), temp.getNotification(), temp.isStatus(), temp.getUser().getUsername());
			bloodNotificationDtoSet.add(dto);
		}
		return bloodNotificationDtoSet;
	}

	@Override
	public void removeNotificationById(int id) {
		this.bloodNotificationRepository.deleteById(id);
	}
	
	@Transactional
	@Override
	public void removeNotification(String username) {
		User user = userRepository.findByUsername(username);
		this.bloodNotificationRepository.deleteByUser(user);
	}
	
	@Override
	public void updateNotificationStatus(int notificationId) {
		BloodNotification bloodNotification = this.bloodNotificationRepository.findById(notificationId).get();
		bloodNotification.setStatus(true);
		this.bloodNotificationRepository.save(bloodNotification);
	}

	@Override
	public void postBloodDonationNotificationThreeMonth(String username) {
		Set<Integer> donor_id = this.bloodDonorRepository.getAllDonorNotification(username);
		User user = userRepository.findByUsername(username);
		for(Integer i:donor_id) {
			BloodDonor donor = bloodDonorRepository.findById(i).get();
			String message = "Three months before You donated "+donor.getBloodGroup()+" blood with Contact Number "+donor.getContactNo()+". Book a slot and save life";
			if(this.bloodNotificationRepository.entryAlreadyThere(user.getId(),message) == 0) {
			this.bloodNotificationRepository.save(new BloodNotification(user,message,false));
			}
		}
	}

	@Override
	public void postBloodDonationNotificationBloodGroup(String bloodGroup) {
		Set<Integer> userId = this.bloodDonorRepository.getAllDonorNotificationBloodGroup(bloodGroup);
		for(Integer i:userId) {
			this.bloodNotificationRepository.save(new BloodNotification(0,this.userRepository.findById(i).get(),"Three months since you have donated blood. There is arequirement of your blood group "+bloodGroup +" Book a slot to donate and save a life.",false));
		}
	}
	
}
