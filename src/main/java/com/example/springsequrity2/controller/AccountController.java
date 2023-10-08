package com.example.springsequrity2.controller;

import com.example.springsequrity2.dto.Account;
import com.example.springsequrity2.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/join")
    public String joinPage(HttpServletRequest request){
        return "join";
    }

    @PostMapping("/join")
    @ResponseBody
    public void join(HttpServletRequest request, @RequestBody Account account){
        accountService.join(account.getId(), account.getPasswd());
    }
}
