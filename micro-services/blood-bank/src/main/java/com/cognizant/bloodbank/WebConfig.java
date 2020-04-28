package com.cognizant.bloodbank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	LOGGER.info("WebMvcConfigurer addCorsMappings() START");
    	registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
    	LOGGER.info("WebMvcConfigurer addCorsMappings() END");
    }

}