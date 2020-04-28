package com.cognizant.bloodbank.DTO;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlotBookingDTO {
	private static final Logger LOGGER = LoggerFactory.getLogger(SlotBookingDTO.class);

	String bloodGroup;
	String state;
	String area;
	int pinCode;
	Long contactNo; 
	String hospitalName;
	String city;
	Date date;
	String time;
	
	public SlotBookingDTO(String bloodGroup, String state, String area, int pinCode, Long contactNo,
			String hospitalName, String city, Date date, String time) {
		LOGGER.info("START");
		this.bloodGroup = bloodGroup;
		this.state = state;
		this.area = area;
		this.pinCode = pinCode;
		this.contactNo = contactNo;
		this.hospitalName = hospitalName;
		this.city = city;
		this.date = date;
		this.time = time;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public int getPinCode() {
		return pinCode;
	}
	
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	public Long getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "SlotBookingDTO [bloodGroup=" + bloodGroup + ", state=" + state + ", area=" + area + ", pinCode="
				+ pinCode + ", contactNo=" + contactNo + ", hospitalName=" + hospitalName + ", city=" + city + ", date="
				+ date + ", time=" + time + "]";
	}

}