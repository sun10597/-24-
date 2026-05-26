//package org.example.springmvc.controller;
//
//import jakarta.validation.Valid;
//import org.example.springmvc.DTO.UserDTO;
//import org.example.springmvc.entity.User;
//import org.example.springmvc.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//    private  final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    //회원가입
//    @GetMapping("/join")
//    public String join(Model model,
//                       @ModelAttribute("dto") UserDTO.Join dto){
//        System.out.println("폼 생성");
//        model.addAttribute("dto", dto);
//        return "user/join";
//    }
//    //회원가입Process
//    @PostMapping("/joinProc")
//    public String joinProc(@Valid @ModelAttribute("dto") UserDTO.Join dto,
//                           BindingResult bindingResult){
////        if(bindingResult.hasErrors()){
////            System.err.println("실패");
////            return"user/join";
////        }
//
//        boolean isSuccess = userService.join(dto);
//        if (!isSuccess){
//            System.err.println("실패");
//            return "redirect:/user/join?error";
//        }
//        System.out.println("성공");
//        return "redirect:/";
//    }
//
//    //
//
//
//}
