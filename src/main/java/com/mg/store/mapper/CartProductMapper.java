package com.mg.store.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mg.store.dto.CartProductDto;
import com.mg.store.entity.CartProduct;

@Mapper
public interface CartProductMapper {

    CartProductMapper INSTANCE = Mappers.getMapper(CartProductMapper.class);

    CartProductDto toDto(CartProduct entity);

    List<CartProductDto> toDto(List<CartProduct> entities);
}
