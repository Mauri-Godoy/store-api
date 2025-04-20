package com.mg.store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mg.store.dto.ProductDto;
import com.mg.store.entity.Product;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto tDto(Product entity);
}
