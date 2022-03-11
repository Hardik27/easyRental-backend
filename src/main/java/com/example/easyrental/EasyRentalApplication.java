package com.example.easyrental;

import com.example.easyrental.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EasyRentalApplication{

    public static void main(String[] args) {
        SpringApplication.run(EasyRentalApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
}
