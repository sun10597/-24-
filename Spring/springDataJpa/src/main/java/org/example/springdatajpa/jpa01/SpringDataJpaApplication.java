package org.example.springdatajpa.jpa01;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataJpaApplication {
    private final UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository){
        return args -> {
            User user1 = new User("kim", "kim@gmail.com", "1234");
            User user2 = new User("sun", "sun@gmail.com", "1234");
            User user3 = new User("qwer", "qwer@gmail.com", "1234");
            userService.addUser(user3);

            userService.updateUser();
        };
    }
}
