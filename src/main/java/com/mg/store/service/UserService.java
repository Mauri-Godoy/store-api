package com.mg.store.service;

import com.mg.store.dto.UserDto;

public interface UserService {

    public UserDto createUser(UserDto userDto);

    public UserDto getByUserName(String username);
}
