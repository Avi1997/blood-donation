package com.cognizant.bloodbank.model;

import java.util.Date;

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
@Table(name="slot_booking")
public class SlotBooking {
	private static final Logger LOGGER = LoggerFactory.getLogger(SlotBooking.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sb_id")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "sb_sl_id")
	private Slot slot;
	
	@NotNull
	@Column(name = "sb_date")
	Date date;
	
	@ManyToOne
	@JoinColumn(name = "sb_bd_id")
	private BloodDonor bloodDonor;
	
	@ManyToOne
	@JoinColumn(name = "sb_ho_id")
	private Hospital hospital;

	public SlotBooking() {
		LOGGER.info("START");
	}

	public SlotBooking( Hospital hospital, Slot slot, Date date, BloodDonor bloodDonor) {
		super();
		this.hospital = hospital;
		this.slot = slot;
		this.date = date;
		this.bloodDonor = bloodDonor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BloodDonor getBloodDonor() {
		return bloodDonor;
	}

	public void setBloodDonor(BloodDonor bloodDonor) {
		this.bloodDonor = bloodDonor;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return "SlotBooking [id=" + id + ", slot=" + slot + ", date=" + date + ", bloodDonor=" + bloodDonor
				+ ", hospital=" + hospital + "]";
	}
	
	
	
}
