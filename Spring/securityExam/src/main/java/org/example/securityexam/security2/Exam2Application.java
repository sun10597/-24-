package org.example.securityexam.security2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@SpringBootApplication
@ServletComponentScan
public class Exam2Application {
    public static void main(String[] args) {

        SpringApplication.run(Exam2Application.class, args);
    }
}