package com.example.MovieTicketBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieTicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingApplication.class, args);
	}

}
