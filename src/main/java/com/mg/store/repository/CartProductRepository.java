package com.mg.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.store.entity.CartProduct;
import com.mg.store.entity.User;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {

    public List<CartProduct> findByCartUser(User user);
}
