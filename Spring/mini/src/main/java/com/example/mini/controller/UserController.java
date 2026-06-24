package com.example.mini.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/myinfo")
    public String info() {
        return "oauth/info";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "oauth/welcome";
    }

    @GetMapping("/loginform")
    public String loginform() {
        return "oauth/user/loginform";
    }

    @GetMapping
    public String info(@AuthenticationPrincipal Object customUserDetails, Model model){
        model.addAttribute("user", customUserDetails);
        return "oauth/info";
    }
}