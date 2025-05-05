package com.mg.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.store.config.ConflictException;
import com.mg.store.dto.UserDto;
import com.mg.store.entity.User;
import com.mg.store.mapper.UserMapper;
import com.mg.store.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ConflictException("El usuario no existe."));
    }

}
