package com.mg.store.service;

import com.mg.store.dto.UserDto;
import com.mg.store.entity.User;

public interface UserService {

    public UserDto createUser(UserDto userDto);

    public User getByUserName(String username);
}
