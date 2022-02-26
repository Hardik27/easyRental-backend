package com.example.easyrental.controller;


import com.example.easyrental.dao.UserRepository;
import com.example.easyrental.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public boolean login(@RequestBody Users user){
        return false;
    }

    @GetMapping("/setList")
    public void setList(){
        return;
    }
}
