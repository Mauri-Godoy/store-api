package com.mg.store.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String category;
    private String imageUrl;
}
