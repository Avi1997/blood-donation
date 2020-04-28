package com.cognizant.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "blood_requirement")
public class BloodRequirement {
 
	@Id
	@Column(name = "br_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@NotNull
	@Column(name = "br_blood_group")
	private String bloodGroup;
	
	@NotNull
	@Column(name = "br_state")
	private String state;
	
	@NotNull
	@Column(name = "br_area")
	private String area;
	
	@NotNull
	@NotNull
	@Column(name = "br_pincode",
			columnDefinition = "INT(6)")
	private long pincode;
	
	@NotNull
	@Size(min = 10, max =10, message = "Enter 10 Digit Mobile Number")
	@Column(name = "br_contact_number")
	private String contactNumber;
	
	public BloodRequirement() {
		super();
	}

	public BloodRequirement(int id, String bloodGroup, String state, String area, long pincode, String contactNumber) {
		super();
		this.id = id;
		this.bloodGroup = bloodGroup;
		this.state = state;
		this.area = area;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
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

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
