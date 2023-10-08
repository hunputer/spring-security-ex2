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

    public static String id;
    public static String authority;
    public static boolean enabled;

    public static void setId(String id){
        LoginUtil.id = id;
    }

    public static void setAuthority(String authority){
        LoginUtil.authority = id;
    }

    public static void setEnabled(Boolean enabled){
        LoginUtil.enabled = enabled;
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
        User user = null;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(principal instanceof String)){
            user = (User)principal;
            account = new Account();
            account.setId(LoginUtil.id);
            account.setEnabled(LoginUtil.enabled);
        }

        return account;
    }
}
