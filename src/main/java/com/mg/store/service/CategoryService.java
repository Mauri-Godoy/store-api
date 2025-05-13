package com.mg.store.service;

import java.util.List;

import com.mg.store.dto.CategoryDto;
import com.mg.store.entity.Category;

public interface CategoryService {

    public Category create(String name);

    public List<CategoryDto> getAll();
}
