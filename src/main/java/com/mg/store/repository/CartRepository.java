package com.mg.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.store.entity.Cart;
import com.mg.store.entity.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByUser(User user);
}
