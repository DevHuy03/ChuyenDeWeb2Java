package com.macquochuy.exercise02.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise02.Entity.Cart;
import com.macquochuy.exercise02.service.CartService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/carts")
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart savedCart = cartService.createCart(cart);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/carts/1
    @GetMapping("{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable("id") Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    // http://localhost:8080/api/carts
    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PutMapping("{id}")
    // http://localhost:8080/api/carts/1
    public ResponseEntity<Cart> updateCart(@PathVariable("id") Long cartId,
                                            @RequestBody Cart cart) {
        cart.setCart_id(cartId); // Thiết lập id cho giỏ hàng cập nhật
        Cart updatedCart = cartService.updateCart(cart);
        if (updatedCart != null) {
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Cart REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") Long cartId) {
        cartService.deleteCart(cartId);
        return new ResponseEntity<>("Cart successfully deleted!", HttpStatus.OK);
    }
}
