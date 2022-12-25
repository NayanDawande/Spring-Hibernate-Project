package com.test.hibernateSpring.TestIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestIntegrationApplication.class, args);
		System.out.println("Spring running....");
	}

}
