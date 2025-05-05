package com.mg.store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mg.store.dto.UserDto;
import com.mg.store.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(UserMapper.class);

    /**
     * Converts a User entity to a UserDto.
     *
     * @param user the User entity to convert
     * @return the converted UserDto
     */
    @Mapping(target = "password", ignore = true)
    UserDto toDto(User user);
}