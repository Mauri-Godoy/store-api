package com.mg.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 500)
    private String description;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int stock;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Category category;
    private String imageUrl;
}
