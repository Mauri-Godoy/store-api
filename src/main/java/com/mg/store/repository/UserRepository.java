package com.mg.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.store.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username); // Custom query method to find user by username
}
