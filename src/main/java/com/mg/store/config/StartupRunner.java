package com.mg.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mg.store.dto.UserDto;
import com.mg.store.service.AuthService;
import com.mg.store.service.ProductService;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private AuthService authService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Insertando productos...");
        productService.insertProducts();

        System.out.println("Insertando usuario de prueba");
        UserDto user = new UserDto();
        user.setEmail("mauu.godoy01@gmail.com");
        user.setUsername("test");
        user.setPassword("1234");
        authService.register(user);
    }

}
