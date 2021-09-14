package com.andredupont.usersApp;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersAppApplication implements ApplicationRunner {

	// Aqui puedo setear mi clase
	// Aqui puedo setear mi repositorio

	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Aqui puedo poblar la BD con for o lo que desee
	}
}
