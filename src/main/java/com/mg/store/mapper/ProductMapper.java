package com.mg.store.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mg.store.dto.ProductDto;
import com.mg.store.entity.Product;

@Mapper(uses = CategoryMapper.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product entity);

    List<ProductDto> toDto(List<Product> entities);

}
