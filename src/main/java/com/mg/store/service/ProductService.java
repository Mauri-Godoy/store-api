package com.mg.store.service;

import java.util.List;

import com.mg.store.dto.ProductDto;

public interface ProductService {
    List<ProductDto> getAllProducts();

    void insertProducts();
}
