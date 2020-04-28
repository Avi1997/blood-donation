package com.cognizant.bloodbank.exception;

public class NoBloodGroupAvailable extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoBloodGroupAvailable() {
	super();
	}
	@Override
	public String toString() {
		return "No Blood Group Available";
	}
}
