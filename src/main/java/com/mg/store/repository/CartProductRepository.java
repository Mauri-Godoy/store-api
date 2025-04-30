package com.mg.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.store.entity.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {

}
