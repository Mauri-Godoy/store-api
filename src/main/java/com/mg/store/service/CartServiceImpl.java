package com.mg.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.store.config.exception.ConflictException;
import com.mg.store.dto.CartDto;
import com.mg.store.entity.Cart;
import com.mg.store.entity.CartProduct;
import com.mg.store.entity.User;
import com.mg.store.mapper.CartMapper;
import com.mg.store.mapper.CartProductMapper;
import com.mg.store.repository.CartProductRepository;
import com.mg.store.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private ProductService productService;

    @Override
    public CartDto createCart(CartDto cartDto, User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
        createCartProducts(cart, cartDto);
        return cartDto;
    }

    private void createCartProducts(Cart cart, CartDto cartDto) {
        if (cartDto.getCartProducts() == null || cartDto.getCartProducts().isEmpty()) {
            throw new ConflictException("No se ingresaron productos en el carrito.");
        }

        List<CartProduct> cartProducts = new ArrayList<>();
        cartDto.getCartProducts().forEach(cProductDto -> {
            CartProduct cartProduct = new CartProduct();
            cartProduct.setCart(cart);
            cartProduct.setPrice(cProductDto.getPrice());
            cartProduct.setQuantity(cProductDto.getQuantity());
            cartProduct.setProduct(productService.getById(cProductDto.getProduct().getId()));
            cartProducts.add(cartProduct);
        });
        cartProductRepository.saveAll(cartProducts);
    }

    @Override
    public List<CartDto> getByUser(User user) {
        List<Cart> carts = cartRepository.findByUser(user);
        List<CartDto> cartDtos = CartMapper.INSTANCE.toDto(carts);

        List<CartProduct> cartProducts = cartProductRepository.findByCartUser(user);
        cartDtos.forEach(cartDto -> {
            List<CartProduct> products = new ArrayList<>();
            cartProducts.forEach(cartProduct -> {
                if (cartProduct.getCart().getId() == cartDto.getId()) {
                    products.add(cartProduct);
                }
            });
            cartDto.setCartProducts(CartProductMapper.INSTANCE.toDto(products));
        });

        return cartDtos;
    }
}
