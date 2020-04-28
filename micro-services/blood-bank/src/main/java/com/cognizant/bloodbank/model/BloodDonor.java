package com.cognizant.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="blood_donor")
public class BloodDonor {
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodDonor.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bd_id")
	private int id;
	
	@NotNull
	@Column(name = "bd_blood_group")
	String bloodGroup;
	
	@NotNull
	@Column(name = "bd_state")
	String state;
	
	@NotNull
	@Column(name = "bd_area")
	String area;
	
	@NotNull
	@Column(name = "bd_pin_code")
	int pinCode;

	@NotNull
	@Column(name = "bd_contact_no")
	Long contactNo;
	
	@ManyToOne
	@JoinColumn(name = "bd_us_id")
	public User user;
	

	public BloodDonor() {
		LOGGER.info("START");
	}

	public BloodDonor( @NotNull String bloodGroup, @NotNull String state, @NotNull String area,
			@NotNull int pinCode, @NotNull Long contactNo) {
		super();
		this.bloodGroup = bloodGroup;
		this.state = state;
		this.area = area;
		this.pinCode = pinCode;
		this.contactNo = contactNo;
	}
	
	
	public BloodDonor( @NotNull String bloodGroup, @NotNull String state, @NotNull String area,
			@NotNull int pinCode, @NotNull Long contactNo, User user) {
		super();
		this.bloodGroup = bloodGroup;
		this.state = state;
		this.area = area;
		this.pinCode = pinCode;
		this.contactNo = contactNo;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "BloodDonor [id=" + id + ", bloodGroup=" + bloodGroup + ", state=" + state + ", area=" + area
				+ ", pinCode=" + pinCode + ", contactNo=" + contactNo + "]";
	}

	
	
}