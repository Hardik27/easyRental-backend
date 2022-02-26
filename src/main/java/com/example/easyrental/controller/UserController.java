package com.example.easyrental.controller;


import com.example.easyrental.dao.UserRepository;
import com.example.easyrental.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public boolean login(@RequestBody User user) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/easy_rental", "admin", "admin");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("email"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @GetMapping("/setList")
    public void setList() {
        return;
    }
}
