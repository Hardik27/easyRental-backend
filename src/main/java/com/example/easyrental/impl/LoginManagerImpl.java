package com.example.easyrental.impl;

import com.example.easyrental.dao.UserRepository;
import com.example.easyrental.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
public class LoginManagerImpl {

    @Autowired
    UserRepository userRepository;

    public String login(Map<String, Object> payLoad){
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

    public String registerUser(Map<String, Object> payLoad){
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
