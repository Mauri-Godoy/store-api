package com.mg.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mg.store.service.ProductService;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Insertando productos...");
        productService.insertProducts();

    }

}
