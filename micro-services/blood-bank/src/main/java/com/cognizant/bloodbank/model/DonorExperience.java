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
@Table(name="donor_experience")
public class DonorExperience {
	private static final Logger LOGGER = LoggerFactory.getLogger(DonorExperience.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "do_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "do_ho_id")
	private Hospital hospital;
	
	@NotNull
	@Column(name = "do_feedback_comments")
	String feedbackComments;

	public DonorExperience() {
		LOGGER.info("START");
	}

	public DonorExperience(int id, Hospital hospital, @NotNull String feedbackComments) {
		super();
		this.id = id;
		this.hospital = hospital;
		this.feedbackComments = feedbackComments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getFeedbackComments() {
		return feedbackComments;
	}

	public void setFeedbackComments(String feedbackComments) {
		this.feedbackComments = feedbackComments;
	}

	@Override
	public String toString() {
		return "UserExperience [id=" + id + ", hospital=" + hospital + ", feedbackComments=" + feedbackComments + "]";
	}
	
}