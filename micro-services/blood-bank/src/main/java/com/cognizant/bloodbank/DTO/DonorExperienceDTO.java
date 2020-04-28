package com.cognizant.bloodbank.DTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DonorExperienceDTO {
	private static final Logger LOGGER = LoggerFactory.getLogger(DonorExperienceDTO.class);
 
	String hospitalName;
	String city;
	String feedbackComments;
	
	public DonorExperienceDTO(String hospitalName, String city, String feedbackComments) {
		LOGGER.info("START");
		this.hospitalName = hospitalName;
		this.city = city;
		this.feedbackComments = feedbackComments;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getFeedbackComments() {
		return feedbackComments;
	}
	
	public void setFeedbackComments(String feedbackComments) {
		this.feedbackComments = feedbackComments;
	}
	
	@Override
	public String toString() {
		return "UserExperienceDTO [hospitalName=" + hospitalName + ", city=" + city + ", feedbackComments="
				+ feedbackComments + "]";
	}

}