package com.example.easyrental;

import com.example.easyrental.dao.UserRepository;
import com.example.easyrental.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EasyRentalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EasyRentalApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
//        User user=new User();
//        user.setFirstName("Hardik");
//        user.setLastName("Ruparel");
//        user.setEmail("abc@gmail.com");
//        user.setCountry("USA");
//        user.setCity("Irvine");
//        user.setPassword("abc123");
//        user.setState("CA");
//        user.setAddressLine1("abc lane");
//        user.setZipcode(123456);
        //userRepository.save(user);
    }
}
