package com.example.EmployeeShift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EmployeeShiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeShiftApplication.class, args);
	}

}
