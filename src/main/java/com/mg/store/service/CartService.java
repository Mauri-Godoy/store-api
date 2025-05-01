package com.mg.store.service;

import java.util.List;

import com.mg.store.dto.CartDto;

public interface CartService {
    public CartDto createCart(CartDto cartDto);

    public List<CartDto> getAllCarts();
}
