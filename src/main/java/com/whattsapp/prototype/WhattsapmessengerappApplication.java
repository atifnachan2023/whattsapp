package com.whattsapp.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class WhattsapmessengerappApplication {

	public static final Logger logger=LoggerFactory.getLogger(WhattsapmessengerappApplication.class) ;


	public static void main(String[] args) {
		SpringApplication.run(WhattsapmessengerappApplication.class, args);

		logger.info("Messenger app Started");

	}





}
