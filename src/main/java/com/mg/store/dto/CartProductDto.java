package com.mg.store.dto;

import lombok.Data;

@Data
public class CartProductDto {
    private Integer id;
    private ProductDto product;
    private int quantity;
    private double price;
}
