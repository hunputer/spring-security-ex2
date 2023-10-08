package com.example.springsequrity2.controller;

import com.example.springsequrity2.dto.Account;
import com.example.springsequrity2.service.AccountService;
import com.example.springsequrity2.util.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final AccountService accountService;

    @GetMapping("/")
    public String main(HttpServletRequest request){

        return "main";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request){

        if(LoginUtil.isLogin()){
            return "redirect:/";
        }

        return "login";
    }

}
