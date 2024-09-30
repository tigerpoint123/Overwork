package com.example.overwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class OverworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(OverworkApplication.class, args);
    }

}
