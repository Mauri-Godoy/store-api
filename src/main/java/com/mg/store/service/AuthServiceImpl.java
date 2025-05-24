package com.mg.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mg.store.dto.TokenDto;
import com.mg.store.dto.UserDto;
import com.mg.store.entity.User;
import com.mg.store.mapper.UserMapper;

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

    @Autowired
    private SmptService smtpService;

    @Override
    public UserDto register(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        smtpService.sendEmail(userDto.getEmail(), "Bienvenido a la tienda",
                "Gracias por registrarte en nuestra tienda");
        return userService.createUser(userDto);
    }

    @Override
    public TokenDto login(UserDto userDto) {
        final User user = userService.getByUserName(userDto.getUsername());
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
        String token = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);
        tokenDto.setRefreshToken(refreshToken);
        tokenDto.setUser(UserMapper.INSTANCE.toDto(user));
        return tokenDto;
    }
}
