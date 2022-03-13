package com.example.easyrental.service;

import com.example.easyrental.dao.UserRepository;
import com.example.easyrental.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceModel implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

}
