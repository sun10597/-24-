package com.example.todoapp.service;

import com.example.todoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.todoapp.entity.User;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;

    public String register(String email, String name, String password){
        if(userRepository.findByEmail(email).isPresent()){
            return "존재하는 아이디 입니다.";
        }
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        userRepository.save(user);

        return "회원가입성공!!";
    }
}
