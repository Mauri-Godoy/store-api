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
                new Product(null, "Product1", "Description1", 100.0, 10, "Category1"),
                new Product(null, "Product2", "Description2", 200.0, 20, "Category2"),
                new Product(null, "Product3", "Description3", 300.0, 30, "Category3")));

        Product newProduct = new Product();
        newProduct.setName("Product4");
        newProduct.setDescription("Description4");
        productRepository.save(newProduct);

        return productRepository.findAll().stream()
                .map(product -> ProductMapper.INSTANCE.tDto(product))
                .toList();
    }

}
