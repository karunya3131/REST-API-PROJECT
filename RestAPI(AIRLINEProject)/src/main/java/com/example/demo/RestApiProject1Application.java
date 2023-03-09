package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBootApplication annotation includes Auto-Configuration, Component Scan, and Spring Boot Configuration. 
//This is the main method of this project from where the program starts
@SpringBootApplication
public class RestApiProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApiProject1Application.class, args);
	  
	}
}
