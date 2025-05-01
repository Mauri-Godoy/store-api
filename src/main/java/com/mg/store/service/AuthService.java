package com.mg.store.service;

import com.mg.store.dto.TokenDto;
import com.mg.store.dto.UserDto;

public interface AuthService {

    public TokenDto register(UserDto userDto);

    public TokenDto login(UserDto userDto);
}
