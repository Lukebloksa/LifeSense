package com.example.lifesense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LifeSenseApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeSenseApplication.class, args);
    }

}
