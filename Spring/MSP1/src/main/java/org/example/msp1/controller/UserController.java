package org.example.msp1.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.msp1.domain.Role;
import org.example.msp1.domain.User;
import org.example.msp1.domain.UserStatus;
import org.example.msp1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    //회원가입
    @GetMapping("/signup")
    public String signUpPage(){
        return "user/signup";
    }
    @PostMapping("/signupProc")
    public String signUpProc(@ModelAttribute User user){
        user.setRole(Role.USER);
        user.setStatus(UserStatus.ACTIVE);
        user.setCreatedAt(LocalDateTime.now());
        userService.addUser(user);
        return "redirect:/users/login";
    }

    //로그인
    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }
    @PostMapping("/loginProc")
    public String loginProc(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session){
        try {
            User loginUser = userService.loginCheck(email, password);
            session.setAttribute("loginUser", loginUser);
            return "redirect:/friends";
        }catch (IllegalArgumentException e){
            return "redirect:/users/login?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/users/login";
    }
//    //관리자 및 친구탐색
//    @GetMapping("/list")
//    public String userList(Model model){
//        Iterable<User> users = userService.getUsers();
//        model.addAttribute("users", users);
//        return "user/list";
//    }

}
