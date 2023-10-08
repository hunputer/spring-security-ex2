package com.example.springsequrity2.util;

import com.example.springsequrity2.dto.Account;
import com.example.springsequrity2.mapper.UserMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class LoginUtil {

    public static Account account;

    public static void setAccount(Account account){
        LoginUtil.account = account;
    }

    public static boolean isLogin(){
        boolean result = true;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof String){
            result = false;
        }

        return result;
    }

    public static Account getUser(){
        Account account = null;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(principal instanceof String)){
            account = LoginUtil.account;
        }

        return account;
    }
}
