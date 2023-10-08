package com.example.springsequrity2.service;

import com.example.springsequrity2.dto.Account;
import com.example.springsequrity2.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService{

    private final UserMapper userMapper;
    //private final BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = new Account();
        account.setId(username);
        account = userMapper.findUser(account);
        if(account != null){
            List<GrantedAuthority> authorities = new ArrayList();
            return new User(account.getId(), "{noop}"+account.getPasswd(), authorities);
        }
        return null;
    }

    public String join(String userId, String userPwd) {
        Account checkUser = new Account();
        checkUser.setId(userId);

        if (userMapper.findUser(checkUser) != null){
            return "아이디가 존재합니다.";
        }
        Account newUser = new Account();
        newUser.setId(userId);
        //newUser.setPasswd(encoder.encode(userPwd));
        userMapper.save(newUser);
        return "회원가입 성공!";
    }

}
