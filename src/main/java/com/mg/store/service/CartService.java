package com.mg.store.service;

import java.util.List;

import com.mg.store.dto.CartDto;
import com.mg.store.entity.User;

public interface CartService {
    public CartDto createCart(CartDto cartDto, User user);

    public List<CartDto> getByUser(User user);
}
