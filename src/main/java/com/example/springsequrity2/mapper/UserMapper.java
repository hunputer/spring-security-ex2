package com.example.springsequrity2.mapper;

import com.example.springsequrity2.dto.Account;
import com.example.springsequrity2.dto.Auth;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Account findUser(Account account);

    int save(Account account);

    Auth findAuthority(Account account);
}
