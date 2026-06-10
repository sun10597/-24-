package org.example.msp1.service;

import lombok.RequiredArgsConstructor;
import org.example.msp1.domain.User;
import org.example.msp1.repository.UserRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User addUser(User user){
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User loginCheck(String email, String password){
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 이메일입니다."));
        if(!user.getPassword().equals(password)){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }
        return user;
    }

}
