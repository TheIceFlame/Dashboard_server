package com.dashboard.samah;

import com.dashboard.samah.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SamahApplication implements CommandLineRunner {

	@Autowired
	private AuthService authService;

	public static void main(String[] args) {
		SpringApplication.run(SamahApplication.class, args);
	}

	@Override
	public void run(String... args) {
		authService.initializeDefaultUser();
	}
}
