package com.mg.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mg.store.dto.TokenDto;
import com.mg.store.dto.UserDto;
import com.mg.store.entity.User;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TokenDto register(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userService.createUser(userDto);
        String token = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);
        tokenDto.setRefreshToken(refreshToken);
        return tokenDto;
    }

    @Override
    public TokenDto login(UserDto userDto) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        final User user = userService.getByUserName(userDto.getUsername());
        String token = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);
        tokenDto.setRefreshToken(refreshToken);
        return tokenDto;
    }
}
