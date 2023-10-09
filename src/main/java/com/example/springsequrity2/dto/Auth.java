package com.example.springsequrity2.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
public class Auth implements GrantedAuthority {

    private String authority;

}
