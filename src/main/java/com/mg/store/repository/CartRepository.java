package com.mg.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.store.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
