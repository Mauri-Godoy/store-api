package com.mg.store.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private LocalDateTime createdAt;
    private String username;
    private String password;
    private String email;
}
