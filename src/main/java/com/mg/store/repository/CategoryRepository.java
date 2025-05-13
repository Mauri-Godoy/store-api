package com.mg.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.store.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
