package com.example.swaggerexam.service;

import com.example.swaggerexam.repository.UserRepository;
import com.example.swaggerexam.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;

    public String register(String email, String password){
        if(userRepository.findByEmail(email).isPresent()){
            return "존재하는 아이디 입니다.";
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);

        return "회원가입성공!!";
    }

}
