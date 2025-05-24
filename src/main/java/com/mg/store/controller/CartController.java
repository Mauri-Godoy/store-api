package com.mg.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mg.store.config.annotation.CurrentUser;
import com.mg.store.dto.CartDto;
import com.mg.store.entity.User;
import com.mg.store.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("")
    public CartDto createCart(@RequestBody CartDto dto, @CurrentUser User user) {
        return cartService.createCart(dto, user);
    }

    @GetMapping("")
    public List<CartDto> getByUser(@CurrentUser User user) {
        return cartService.getByUser(user);
    }

}
