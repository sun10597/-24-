package org.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "/hello/hello";
    }

    @GetMapping("/hi")
    public String hi(){
        return "/hello/hi";
    }
    
    @GetMapping("/home")
    public String home(HttpServletRequest httpServletRequest){
        String name = httpServletRequest.getParameter("name");
        httpServletRequest.setAttribute("name", name);
        httpServletRequest.setAttribute("msg", "Welcome");
        httpServletRequest.setAttribute("timestamp", LocalDateTime.now());
        System.out.println(name);
        return "/hello/home";
    }

    @GetMapping("/home2")
    public String home2(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("msg", "Welcome");
        model.addAttribute("timestamp", LocalDateTime.now());
        return "/hello/home";
    }

    @GetMapping("/index")
    public String index(
            @RequestParam(value = "name", required = false, defaultValue = "guest") String name,
            @RequestParam(value = "msg", required = false) String msg,
            Model model){
        model.addAttribute("name", name);
        model.addAttribute("msg", msg);
        model.addAttribute("timestamp", LocalDateTime.now());
        return "/hello/home";
    }

    @GetMapping("/index2")
    public String index2(
            @RequestParam(value = "name", required = false, defaultValue = "guest") String name,
            @RequestParam(value = "msg", required = false) String msg){

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", name);
        modelAndView.addObject("msg", msg);
        return "/hello/home";
    }
}
