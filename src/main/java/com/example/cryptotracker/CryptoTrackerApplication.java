package com.example.cryptotracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // <--- ACTIVA EL RELOJ INTERNO
public class CryptoTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoTrackerApplication.class, args);
	}

}
