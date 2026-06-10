package org.example.springdatajpa.jpa01;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User updateUser(User user) {
        User byId = userRepository.findById(user.getId().describeConstable().orElseThrow(()-> new IllegalArgumentException("사용자를 찾을수 없습니다."));
        byId.setName(user.getName());
        byId.setEmail(user.getEmail());
        byId.setPassword(user.getPassword());
        return byId;
    }
}
