package com.cognizant.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity()
@Table(name ="blood_availability")
public class BloodAvailability {

	@Id
	@Column(name = "ba_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@NotNull
	@Column(name = "ba_blood_group")
	private String bloodGroup;
	
	@NotNull
	@Column(name = "ba_state")
	private String state;
	
	@NotNull
	@Column(name = "ba_area")
	private String area;
	
	@NotNull
	@NotNull
	@Column(name = "ba_pincode",
			columnDefinition = "INT(6)")
	private long pincode;
	
	@NotNull
	@Size(min = 10, max =10, message = "Enter 10 Digit Mobile Number")
	@Column(name = "ba_contact_number")
	private long contactNumber;
	
	
	public BloodAvailability() {
		super();
	}

	public BloodAvailability(int id, String bloodGroup, String state, String area, long pincode, long contactNumber) {
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

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "BloodAvailability [id=" + id + ", bloodGroup=" + bloodGroup + ", state=" + state + ", area=" + area
				+ ", pincode=" + pincode + ", contactNumber=" + contactNumber + "]";
	}
}
