package org.example.springdatajpa.jpa02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


    @Bean
    public CommandLineRunner run(CustomerRepository customerRepository) {
        return args -> {
            Customer customer = new Customer("kim", "kim@gmail.com");
            customerRepository.save(customer);
        };
    }
}
