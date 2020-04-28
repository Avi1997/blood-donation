package com.cognizant.bloodbank.service;



import java.text.SimpleDateFormat;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.DTO.SlotBookingDTO;
import com.cognizant.bloodbank.exception.SlotAlreadyTaken;
import com.cognizant.bloodbank.model.BloodDonor;
import com.cognizant.bloodbank.model.Hospital;
import com.cognizant.bloodbank.model.Slot;
import com.cognizant.bloodbank.model.SlotBooking;
import com.cognizant.bloodbank.repository.BloodDonorRepository;
import com.cognizant.bloodbank.repository.HospitalBookingRepository;
import com.cognizant.bloodbank.repository.SlotBookingRepository;
import com.cognizant.bloodbank.repository.SlotRepository;
import com.cognizant.bloodbank.repository.UserRepository;

@Service()
public class HospitalBookingServiceImpl implements HospitalBookingService {
	private static final Logger LOGGER = LoggerFactory.getLogger(HospitalBookingServiceImpl.class);
	@Autowired
	HospitalBookingRepository hospitalBookingRepository;
	@Autowired
	BloodDonorRepository bloodDonorRepository;
	@Autowired
	SlotRepository slotRepository;
	@Autowired
	SlotBookingRepository slotBookingrepository;
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public void addTimeSlot(SlotBookingDTO slotBookingDTO,String username) {	
		LOGGER.info("addTimeSlot Start");		
		Hospital hospitalBackEnd  = hospitalBookingRepository.findByHospitalNameAndCity(slotBookingDTO.getHospitalName(),slotBookingDTO.getCity());
		if(hospitalBackEnd == null) {
			Hospital hospital  = new Hospital(slotBookingDTO.getHospitalName(),slotBookingDTO.getCity());
			hospitalBookingRepository.save(hospital);		
		}
		hospitalBackEnd  = hospitalBookingRepository.findByHospitalNameAndCity(slotBookingDTO.getHospitalName(),slotBookingDTO.getCity());
		BloodDonor bloodDonorBackEnd = bloodDonorRepository.findByBloodGroupAndStateAndAreaAndPinCodeAndContactNo
				(slotBookingDTO.getBloodGroup(),slotBookingDTO.getState(),slotBookingDTO.getArea(),
				slotBookingDTO.getPinCode(),slotBookingDTO.getContactNo());
		if(bloodDonorBackEnd == null) {
			BloodDonor bloodDonor = new BloodDonor(slotBookingDTO.getBloodGroup(),slotBookingDTO.getState(),slotBookingDTO.getArea(),
					slotBookingDTO.getPinCode(),slotBookingDTO.getContactNo(),userRepository.findByUsername(username));
			bloodDonorRepository.save(bloodDonor);		
		}
		bloodDonorBackEnd = bloodDonorRepository.findByBloodGroupAndStateAndAreaAndPinCodeAndContactNo
				(slotBookingDTO.getBloodGroup(),slotBookingDTO.getState(),slotBookingDTO.getArea(),
				slotBookingDTO.getPinCode(),slotBookingDTO.getContactNo());
		Slot slot = slotRepository.findByTime(slotBookingDTO.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format( slotBookingDTO.getDate());
		
		int slotBookingLength = this.slotBookingrepository.checkSlot(hospitalBackEnd.getId(),slot.getId(),date);
		System.out.println(slotBookingLength);
		if(slotBookingLength == 0) {
			SlotBooking slotBooking = new SlotBooking(hospitalBackEnd,slot,slotBookingDTO.getDate(),bloodDonorBackEnd); 
			slotBookingrepository.save(slotBooking);
		}else {
			throw new SlotAlreadyTaken();
		}
		LOGGER.info("END Add Donar");
	}

}
