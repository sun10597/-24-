package org.example.securityexam.security1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/test")
    public String test(){
        System.out.println("UserController test() 실행!");
        System.out.println("UserFilter에서 전달한값 : " + FConfig.UserContext.getUser().getName());


        return "test";
    }
}
