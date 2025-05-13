package com.mg.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mg.store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p " +
            "FROM Product p " +
            "WHERE (LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "   OR LOWER(p.description) LIKE LOWER(CONCAT('%', :search, '%'))) " +
            "AND (:categoryId IS NULL OR p.category.id = :categoryId)")
    List<Product> searchByNameDescriptionAndCategoryId(String search, Integer categoryId);

}
