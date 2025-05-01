package com.mg.store.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mg.store.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.expiration}")
    private long expirationTime;
    @Value("${jwt.refresh-token.expiration}")
    private long refreshTokenExpirationTime;

    public String generateToken(final User user) {
        return buildToken(user, expirationTime);
    }

    public String generateRefreshToken(final User user) {
        return buildToken(user, refreshTokenExpirationTime);
    }

    private String buildToken(User user, long expirationTime) {
        // Lógica para construir el token JWT
        return Jwts.builder()
                .id(user.getId().toString())
                .claim("name", user.getUsername())
                .subject(user.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getSecretKey())
                .compact();
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    private boolean isTokenExpired(String token) {
        Date expirationDate = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        return expirationDate.before(new Date());
    }

    @Override
    public boolean isTokenValid(String token, User user) {
        String username = extractUsername(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }
}