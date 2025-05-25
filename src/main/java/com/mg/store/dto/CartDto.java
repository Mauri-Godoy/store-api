package com.mg.store.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class CartDto {

    private Integer id;
    private LocalDateTime createdAt;
    private List<CartProductDto> cartProducts;
    private double total;
}
