package com.smarthouse.usermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @GetMapping()
    public List<String> getAllUsers() {
        return List.of("User1", "User2", "User3");
    }
}