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

@Entity
@Table( name = "user_notification")
public class BloodNotification {
	
	@Id
	@Column(name = "un_id",
			columnDefinition = "INT(11,0)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "un_us_id")
	private User user;
	
	@NotNull
	@Column(name = "un_notification")
	private String notification;
	
	@NotNull
	@Column(name = "un_status")
	private boolean status;

	public BloodNotification() {
		super();
	}
	
	public BloodNotification(@NotNull int id, @NotNull User user, @NotNull String notification,
			@NotNull boolean status) {
		super();
		this.id = id;
		this.user = user;
		this.notification = notification;
		this.status = status;
	}
	
	

	public BloodNotification(@NotNull User user, @NotNull String notification, @NotNull boolean status) {
		super();
		this.user = user;
		this.notification = notification;
		this.status = status;
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

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BloodNotification [id=" + id + ", user=" + user + ", notification=" + notification + ", status="
				+ status + "]";
	}

}
