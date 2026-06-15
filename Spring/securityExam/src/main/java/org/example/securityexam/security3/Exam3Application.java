package org.example.securityexam.security3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Exam3Application {
    public static void main(String[] args) {

        SpringApplication.run(Exam3Application.class, args);
    }
}