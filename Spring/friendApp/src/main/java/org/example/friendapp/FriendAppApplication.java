package org.example.friendapp;

import org.example.friendapp.Repository.FriendRepository;
import org.example.friendapp.domain.Friend;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FriendAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendAppApplication.class, args);
	}

//    @Bean
//    CommandLineRunner init(FriendRepository friendRepository){
//        return args -> {
//            Friend newFriend = new Friend("sun", "sun@sun");
//            friendRepository.save(newFriend);
//            friendRepository.save(new Friend("carami", "carami@gmail.com"));
//        };
//    }
}
