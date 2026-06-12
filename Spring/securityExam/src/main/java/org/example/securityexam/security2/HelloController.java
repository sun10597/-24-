package org.example.securityexam.security2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        log.info("HelloController hello() 실행!");
        return "hello";
    }

    @GetMapping("/hi")
    public String hi(){
        System.out.println("HelloController hi() 실행!");
        return "hi";
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("HelloController test() 실행!");
        return "test";
    }

}
