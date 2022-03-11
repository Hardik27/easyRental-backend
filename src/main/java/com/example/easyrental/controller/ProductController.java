package com.example.easyrental.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class ProductController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody Map<String, Object> payload){
        return "ok";
    }

}
