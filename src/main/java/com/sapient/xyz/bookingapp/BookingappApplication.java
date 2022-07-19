package com.sapient.xyz.bookingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sapient.xyz.bookingapp")
public class BookingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingappApplication.class, args);
	}

}
