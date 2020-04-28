package com.cognizant.bloodbank.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAlreadyExistsException.class);
	public UserAlreadyExistsException() {
		super();
		LOGGER.info("START");
	}

	@Override
	public String toString() {
		return "User already exists !!";
	}
}