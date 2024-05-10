package com.macquochuy.exercise02.service;

import java.util.List;

import com.macquochuy.exercise02.Entity.Cart;

public interface CartService {
    Cart createCart(Cart cart);
    Cart getCartById(Long cartId);
    List<Cart> getAllCarts();
    Cart updateCart(Cart cart);
    void deleteCart(Long cartId);
}
