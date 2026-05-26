package org.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CookieController {

    @GetMapping("/cookieForm")
    public String cookieForm(){
        return "user/cookieForm";
    }

    @GetMapping("/addCookie")
    public String addCookie(@RequestParam String cookieName,
                            @RequestParam String cookieValue,
                            Model model,
                            HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24);

        httpServletResponse.addCookie(cookie);

        return "redirect:/cookieView";
    }

    @GetMapping("/cookieView")
    public String cookieView(HttpServletRequest httpServletRequest,
                             Model model){
        Cookie[] cookies = httpServletRequest.getCookies();
        Map<String, String> cookieMap = new HashMap<>();
        List<String> cookieList = new ArrayList<>();

        if(cookies != null){
            for(Cookie cookie : cookies){
                cookieList.add(cookie.getName() + cookie.getValue());
//                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }

        model.addAttribute("cookieList", cookieList);

        return "user/cookieView";
    }

    @GetMapping("/cookieDelete")
    public String cookieDelete(@RequestParam String cookieName,
                               @RequestParam String cookieValue,
                               HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        httpServletResponse.addCookie(cookie);
        return "user/cookieView";
    }
}
