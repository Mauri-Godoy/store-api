package com.mg.store.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mg.store.dto.CartDto;
import com.mg.store.entity.Cart;

@Mapper
public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    @Mapping(target = "cartProducts", ignore = true)
    CartDto toDto(Cart entity);

    List<CartDto> toDto(List<Cart> entities);
}
