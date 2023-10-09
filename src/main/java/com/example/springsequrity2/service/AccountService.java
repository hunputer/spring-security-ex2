package com.example.springsequrity2.service;

import com.example.springsequrity2.dto.Account;
import com.example.springsequrity2.mapper.UserMapper;
import com.example.springsequrity2.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService{

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = new Account();
        account.setId(username);
        account = userMapper.findUser(account);
        if(account != null){
            List<GrantedAuthority> authorities = new ArrayList();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            account.setAuthorities(authorities);
            LoginUtil.setAccount(account);
            return new User(account.getId(), account.getPasswd(), authorities);
        }
        return null;
    }

    @Transactional
    public void join(String userId, String userPwd) throws DuplicateKeyException{
        Account checkUser = new Account();
        checkUser.setId(userId);

        if (userMapper.findUser(checkUser) != null){
            throw new DuplicateKeyException("DuplicateKey Exception!!");
        }
        Account newUser = new Account();
        newUser.setId(userId);
        newUser.setPasswd(encoder.encode(userPwd));
        userMapper.save(newUser);
    }

    public Account getAccount(Account account){
        return userMapper.findUser(account);
    }

}
