package com.example.springsequrity2.util;

import com.example.springsequrity2.dto.Account;
import com.example.springsequrity2.mapper.UserMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.List;

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

    public static boolean isManager(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(principal instanceof String)){
            if(LoginUtil
                    .account
                    .getAuthorities()
                    .stream()
                    .anyMatch(auth -> "ROLE_ADMIN".equals(auth.getAuthority()))){
                return true;
            }
        }
        return false;
    }

    public static boolean isUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(principal instanceof String)){
            if(LoginUtil
                    .account
                    .getAuthorities()
                    .stream()
                    .anyMatch(auth -> "ROLE_USER".equals(auth.getAuthority()))){
                return true;
            }
        }
        return false;
    }
}
