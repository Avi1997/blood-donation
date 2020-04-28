package com.cognizant.bloodbank.model;

public class ErrorCode {
	String message;
	boolean status;
	int code;
	public ErrorCode(String message, boolean status, int code) {
		super();
		this.message = message;
		this.status = status;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	

}
