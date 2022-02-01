package com.addressbook;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
		log.info("nithun has started running in {} environment ",context.getEnvironment().getProperty("environment"));
	}

}
