package com.mg.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mg.store.dto.CategoryDto;
import com.mg.store.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

}
