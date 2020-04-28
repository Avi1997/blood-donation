package com.cognizant.bloodbank.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.model.DonorExperience;
import com.cognizant.bloodbank.DTO.DonorExperienceDTO;
import com.cognizant.bloodbank.model.Hospital;
import com.cognizant.bloodbank.repository.DonorExperienceRepository;
import com.cognizant.bloodbank.repository.HospitalBookingRepository;


@Service
public class DonorExperienceServiceImpl implements DonorExperienceService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DonorExperienceServiceImpl.class);

	@Autowired
	DonorExperienceRepository donorExperienceRepository;
	@Autowired
	HospitalBookingRepository hospitalBookingRepository;
	
	@Override
	@Transactional
	public boolean postDonorExperience(DonorExperienceDTO donorExperienceDTO) {
		LOGGER.info("START");
		Hospital hospital = hospitalBookingRepository.findByHospitalNameAndCity
				(donorExperienceDTO.getHospitalName(), donorExperienceDTO.getCity());
		if(hospital == null) {
			Hospital newHospital = new Hospital();
			newHospital.setHospitalName(donorExperienceDTO.getHospitalName());
			newHospital.setCity(donorExperienceDTO.getCity());
			hospitalBookingRepository.save(newHospital);
		}
		hospital = hospitalBookingRepository.findByHospitalNameAndCity
				(donorExperienceDTO.getHospitalName(), donorExperienceDTO.getCity());
		DonorExperience donorExperience = new DonorExperience();
		donorExperience.setHospital(hospital);
		donorExperience.setFeedbackComments(donorExperienceDTO.getFeedbackComments());
		donorExperienceRepository.save(donorExperience);
		return true;
	}

	@Override
	@Transactional
	public List<DonorExperienceDTO> getAllDonorExperience() {
		LOGGER.info("START");
		List<DonorExperience> donorExperienceList = this.donorExperienceRepository.findAll();
		List<DonorExperienceDTO> donorExperienceDTOList = new ArrayList<DonorExperienceDTO>();
		for (DonorExperience donorExperience : donorExperienceList) {
			Hospital hospital = donorExperience.getHospital();
			DonorExperienceDTO donorExperienceDTO = new DonorExperienceDTO
					(hospital.getHospitalName(), hospital.getCity(), donorExperience.getFeedbackComments());
			donorExperienceDTOList.add(donorExperienceDTO);
		}
		return donorExperienceDTOList;
	}
}
