package com.mg.store.service;

import com.mg.store.dto.TokenDto;
import com.mg.store.dto.UserDto;

public interface AuthService {

    public UserDto register(UserDto userDto);

    public TokenDto login(UserDto userDto);
}
