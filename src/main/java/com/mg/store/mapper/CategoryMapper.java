package com.mg.store.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mg.store.dto.CategoryDto;
import com.mg.store.entity.Category;

@Mapper()
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDto(Category category);

    List<CategoryDto> toDto(List<Category> categories);

}
