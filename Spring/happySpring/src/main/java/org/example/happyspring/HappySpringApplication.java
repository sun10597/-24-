package org.example.happyspring;

import jdk.jfr.SettingDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class HappySpringApplication {

	public static void main(String[] args) {
        SpringApplication.run(HappySpringApplication.class, args);
    }
    // @PostMapping
    //@PutMapping
    //@PatchMapping
    //@GetMapping
    //@DeleteMapping


    @GetMapping("/")
    public String index(){
        return"hello spring";
    }
}
