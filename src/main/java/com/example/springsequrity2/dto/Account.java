package com.example.springsequrity2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String id;
    private String email;
    private String password;
    private String authority;
}
