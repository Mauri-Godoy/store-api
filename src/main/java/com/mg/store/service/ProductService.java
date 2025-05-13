package com.mg.store.service;

import java.util.List;

import com.mg.store.dto.ProductDto;
import com.mg.store.entity.Product;

public interface ProductService {
    List<ProductDto> getAllProducts(String search, Integer categoryId);

    void insertProducts();

    Product getById(Integer id);

    ProductDto getDtoById(Integer id);
}
