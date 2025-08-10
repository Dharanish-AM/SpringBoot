package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String checkServer() {
        return "Hello World";
    }

    @GetMapping("/users")
    public List<User> fetchAllUsers() {
        return userService.getAllUsers();
    }

}