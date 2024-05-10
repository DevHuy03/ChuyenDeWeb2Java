package com.macquochuy.exercise02.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.Cart;
import com.macquochuy.exercise02.Repository.CartRepository;
import com.macquochuy.exercise02.service.CartService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart createCart(Cart cart) {
        cart.setCreated_at(new Date());
        cart.setUpdated_at(new Date());
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        return optionalCart.orElse(null);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart updateCart(Cart cart) {
        Optional<Cart> optionalExistingCart = cartRepository.findById(cart.getCart_id());

        if (optionalExistingCart.isPresent()) {
            Cart existingCart = optionalExistingCart.get();
            existingCart.setUser(cart.getUser());
            existingCart.setUpdated_at(new Date());

            return cartRepository.save(existingCart);
        } else {
            // Return null if the cart doesn't exist
            return null;
        }
    }

    @Override
    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
