package org.example.securityexam.security2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "main";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
