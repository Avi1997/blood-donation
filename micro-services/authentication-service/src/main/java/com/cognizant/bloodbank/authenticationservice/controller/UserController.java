package com.cognizant.bloodbank.authenticationservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.authenticationservice.exception.UserAlreadyExistsException;
import com.cognizant.bloodbank.authenticationservice.model.User;
import com.cognizant.bloodbank.authenticationservice.repository.UserRepository;
import com.cognizant.bloodbank.authenticationservice.security.AppUserDetailsService;

@RestController
@RequestMapping("/blood-bank")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder; 
	
	@GetMapping("/users-all")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/users")
	public boolean signup(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		LOGGER.info("SIGNUP controller Start");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		LOGGER.info("SIGNUP controller End");
		return appUserDetailsService.signup(user);
	}
}