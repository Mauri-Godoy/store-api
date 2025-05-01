package com.mg.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mg.store.dto.CartDto;
import com.mg.store.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("")
    public CartDto createCart(@RequestBody CartDto dto) {
        return cartService.createCart(dto);
    }

    @GetMapping("")
    public List<CartDto> getAll() {
        return cartService.getAllCarts();
    }

}
