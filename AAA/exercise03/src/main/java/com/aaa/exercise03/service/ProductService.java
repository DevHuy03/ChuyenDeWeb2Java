package com.aaa.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.Product;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(UUID productId);

    List<Product> getAllProducts();

    Product updateProduct(Product product);
    
    void deleteProduct(UUID productId);
}