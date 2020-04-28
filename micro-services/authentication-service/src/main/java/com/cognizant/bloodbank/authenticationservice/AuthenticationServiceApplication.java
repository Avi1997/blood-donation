package com.cognizant.bloodbank.authenticationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AuthenticationServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Start Main Application");
		SpringApplication.run(AuthenticationServiceApplication.class, args);
		LOGGER.info("End Main Application");
	}

}
