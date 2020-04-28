package com.cognizant.bloodbank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BloodBankApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodBankApplication.class);
	public static void main(String[] args) {
		LOGGER.info("Start");
		SpringApplication.run(BloodBankApplication.class, args);
		LOGGER.info("END");
	}

}
