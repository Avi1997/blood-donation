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
@Table(name="faq")
public class FAQ {
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQ.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fa_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "fa_us_id")
	private User user;
	
	@NotNull
	@Column(name = "fa_question")
	String question;

	@Column(name = "fa_answer")
	String answer;
	
	public FAQ() {
		LOGGER.info("START");
	}
	

	public FAQ(User user, @NotNull String question, String answer) {
		super();
		this.user = user;
		this.question = question;
		this.answer = answer;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
}
