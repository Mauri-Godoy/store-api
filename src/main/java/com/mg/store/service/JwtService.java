package com.mg.store.service;

import com.mg.store.dto.UserDto;

public interface JwtService {

    public String generateToken(UserDto user);

    public String generateRefreshToken(UserDto user);

    public String extractUsername(String token);

    public boolean isTokenValid(String token, UserDto user);
}
