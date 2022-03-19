package com.example.easyrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@Configuration
public class EasyRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyRentalApplication.class, args);
    }

}
