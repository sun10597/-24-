package org.example.happyspring.controller;

import org.example.happyspring.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/list")
    public String list(){
        return"list";
    }

    @GetMapping("/user")
    public String getUser(){
        User user = new User();
        user.setUsername("sun");
        user.setPassword("1234");
        user.setPhone("010-1234-1234");
        user.setEmail("sun@gmail.com");
        return user.toString();
    }
}
