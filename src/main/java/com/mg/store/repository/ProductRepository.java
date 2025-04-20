package com.mg.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
