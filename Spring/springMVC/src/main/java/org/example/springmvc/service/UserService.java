//package org.example.springmvc.service;
//
//import org.example.springmvc.entity.User;
//import org.example.springmvc.DTO.UserDTO;
//import org.example.springmvc.repository.UserRepository;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    private UserRepository userRepository;
////    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public UserService(UserRepository userRepository
////                       BCryptPasswordEncoder bCryptPasswordEncoder
//    ){
//        this.userRepository = userRepository;
////        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    public Boolean join(UserDTO.Join dto){
//        if (userRepository.existsByEmail(dto.getEmail())){
//            System.err.println("=====================");
//            return false;
//        }
//
//        User user = new User();
//        user.setEmail(dto.getEmail());
//
////        String rawPassword = dto.getPassword();
////        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
////        user.setPassword(encPassword);
//        user.setPassword(dto.getPassword());
//
//        user.setName(dto.getName());
//
//        userRepository.save(user);
//        return true;
//    }
//}
