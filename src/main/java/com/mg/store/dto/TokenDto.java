package com.mg.store.dto;

import lombok.Data;

@Data
public class TokenDto {
    private String token;
    private String refreshToken;
    private UserDto user;
}
