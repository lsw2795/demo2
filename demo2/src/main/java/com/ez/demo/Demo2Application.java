package com.ez.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
		//SpringApplication.run(Demo2Application.class, args);
		
		SpringApplication app = new SpringApplication(Demo2Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "9091"));
		app.run(args);
	}

}
