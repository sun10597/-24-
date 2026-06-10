package org.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/loginProc")
    public String loginProc(@RequestParam("id") String id,
                            @RequestParam("password") String passWord,
                            HttpServletResponse httpServletResponse,
                            RedirectAttributes redirectAttributes) {
        if ("sun".equals(id) && "1234".equals(passWord)) {
            Cookie cookie = new Cookie("loginCookie", id);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24);

            httpServletResponse.addCookie(cookie);

            return "redirect:/user/userList";
        } else {
            redirectAttributes.addFlashAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "redirect:/login";
        }
    }

    @GetMapping("/user/userList")
    public String userList(@CookieValue("loginCookie") String id){
        if(id != null){
            return "user/userList";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("loginCookie", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);

        httpServletResponse.addCookie(cookie);
        return "redirect:/login";
    }

}
