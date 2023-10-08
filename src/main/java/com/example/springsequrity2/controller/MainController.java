package com.example.springsequrity2.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(HttpServletRequest request){
        return "main";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request){
        return "login";
    }

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        return "hello";
    }

}
