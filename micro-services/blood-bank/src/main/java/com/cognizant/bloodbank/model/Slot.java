package com.cognizant.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="slot")
public class Slot {
	private static final Logger LOGGER = LoggerFactory.getLogger(Slot.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sl_id")
	private int id;
	
	@NotNull
	@Column(name = "sl_time")
	String time;

	public Slot() {
		LOGGER.info("START");
	}

	public Slot(int id, @NotNull String time) {
		super();
		this.id = id;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Slot [id=" + id + ", time=" + time + "]";
	}

}
