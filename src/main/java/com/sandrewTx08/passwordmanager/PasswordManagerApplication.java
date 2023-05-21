package com.sandrewTx08.passwordmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PasswordManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PasswordManagerApplication.class, args);
	}
}
