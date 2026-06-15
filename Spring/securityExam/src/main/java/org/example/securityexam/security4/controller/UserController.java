package org.example.securityexam.security4.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.securityexam.security4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/registerProc")
    public String registerProc(){
        return "redirect:/login";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
    @PostMapping("loginProc")
    public  String loginProc(){
        return "redirect:/";
    }
}
