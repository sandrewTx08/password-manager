package com.passwordmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@PropertySource("file:.env")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
