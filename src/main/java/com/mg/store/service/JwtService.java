package com.mg.store.service;

import com.mg.store.entity.User;

public interface JwtService {

    public String generateToken(User user);

    public String generateRefreshToken(User user);

    public String extractUsername(String token);

    public boolean isTokenValid(String token, User user);
}
