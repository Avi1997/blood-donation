package com.cognizant.bloodbank.DTO;

public class BloodNotificationDto {
	private int id;
	private String notification;
	private boolean status;
	private String username;
	public BloodNotificationDto(int id, String notification, boolean status, String username) {
		super();
		this.id = id;
		this.notification = notification;
		this.status = status;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
