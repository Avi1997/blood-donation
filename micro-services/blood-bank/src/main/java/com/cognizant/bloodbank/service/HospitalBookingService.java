package com.cognizant.bloodbank.service;

import com.cognizant.bloodbank.DTO.SlotBookingDTO;

public interface HospitalBookingService {
	public void addTimeSlot(SlotBookingDTO slotBookingDTO,String username) ;
}
