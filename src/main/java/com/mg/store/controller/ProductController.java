package com.mg.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mg.store.dto.ProductDto;
import com.mg.store.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductDto> getAllProducts(@RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false) Integer categoryId) {
        return productService.getAllProducts(search, categoryId);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Integer id) {
        return productService.getDtoById(id);
    }
}
