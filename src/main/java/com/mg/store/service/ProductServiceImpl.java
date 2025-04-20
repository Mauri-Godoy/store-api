package com.mg.store.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.store.dto.ProductDto;
import com.mg.store.entity.Product;
import com.mg.store.mapper.ProductMapper;
import com.mg.store.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        productRepository.saveAll(Arrays.asList(
                new Product(1, "Product1", "Description1", 100.0, 10, "Category1"),
                new Product(2, "Product2", "Description2", 200.0, 20, "Category2"),
                new Product(3, "Product3", "Description3", 300.0, 30, "Category3")));
        return productRepository.findAll().stream()
                .map(product -> ProductMapper.INSTANCE.tDto(product))
                .toList();
    }

}
