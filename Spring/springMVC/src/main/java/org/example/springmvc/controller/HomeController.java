package org.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.example.springmvc.DTO.ContactFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC!");
        model.addAttribute("timestamp", LocalDateTime.now());
        return "hello/home";  // views/home.html
    }

    @GetMapping("/about")
    public String about() {
        return "about";  // views/about.html
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "guest") String name,
                           Model model){
        model.addAttribute("msg", "안녕하세요 [" + name + "]님!");
        return "home/greeting";
    }

    @GetMapping("/counter")
    public String counter(@CookieValue(value = "visitCount", defaultValue = "0") int visitCount,
                          HttpServletResponse httpServletResponse,
                          Model model){
        int count = visitCount + 1;

        Cookie cookie = new Cookie("visitCount", String.valueOf(count));
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);

        model.addAttribute("count", count);
        return "home/counter";
    }

    @GetMapping("/contact")
    public String contactForm(){
        return "home/contactForm";
    }

    @PostMapping("/contactProc")
    public String contactProc(@ModelAttribute ContactFormDTO dto,
                              RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("dto", dto);
        redirectAttributes.addFlashAttribute("msg", "연락처가 저장되었습니다.");
        return "redirect:/contact/success";
    }

    @GetMapping("/contact/success")
    public  String success(){
        return "home/success";
    }
}
