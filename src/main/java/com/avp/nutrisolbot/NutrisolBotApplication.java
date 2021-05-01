package com.avp.nutrisolbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;


@SpringBootApplication
public class NutrisolBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(NutrisolBotApplication.class, args);
	}

}
