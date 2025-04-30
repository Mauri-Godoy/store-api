package com.mg.store.dto;

import java.util.List;

import lombok.Data;

@Data
public class CartDto {

    private Integer id;
    private List<CartProductDto> products;
}
