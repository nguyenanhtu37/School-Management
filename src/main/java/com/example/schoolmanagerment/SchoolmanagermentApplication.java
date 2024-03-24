package com.example.schoolmanagerment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.schoolmanagerment")
public class SchoolmanagermentApplication {
	public static void main(String[] args) {
		SpringApplication.run(SchoolmanagermentApplication.class, args);
	}
}
