package com.example.easyrental.controller;


import com.example.easyrental.dao.UserRepository;
import com.example.easyrental.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST)
    public String login(@RequestBody Map<String, Object> payLoad){
        System.out.println("Here####");
        String email=(String)payLoad.get("email");
        String password=(String)payLoad.get("password");
        Users currUser=userRepository.findByEmail(email);
        if(currUser!=null){
            System.out.println(email+","+password);
            if(currUser.getPassword().equals(password)){
                System.out.println("Login Successful");
                return "Login successful";
            }
        }
        System.out.println("Login Failed.....");
        return "Invalid login";

    }


    @RequestMapping(
            value = "/registerUser",
            method = RequestMethod.POST)
    public String registerUser(@RequestBody Map<String, Object> payLoad){
        String firstName=(String)payLoad.get("firstName");
        String lastName=(String)payLoad.get("lastName");
        String email=(String)payLoad.get("email");
        String password=(String)payLoad.get("password");
        String mobile=(String) payLoad.get("mobile");
        String country=(String) payLoad.get("country");
        String addressLine1=(String) payLoad.get("addressLine1");
        String addressLine2=(String) payLoad.get("addressLine2");
        String city=(String)payLoad.get("city");
        String state=(String)payLoad.get("state");
        String zipCode=(String)payLoad.get("zipCode");
        int zip=Integer.parseInt(zipCode);
        Users currUser=userRepository.findByEmail(email);
        if(currUser!=null){
            System.out.println("Same user with same email id found");
            return "User Found with same email";
        }
        Users user=new Users(firstName, lastName, country, addressLine1, addressLine2, city, state, zip, email, password, mobile);
        userRepository.save(user);
        System.out.println("Save complete.....");
        return "Save Complete...";
    }
}
