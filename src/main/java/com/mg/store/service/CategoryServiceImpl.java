package com.mg.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.store.dto.CategoryDto;
import com.mg.store.entity.Category;
import com.mg.store.mapper.CategoryMapper;
import com.mg.store.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> getAll() {
        return CategoryMapper.INSTANCE.toDto(categoryRepository.findAll());
    }
}
