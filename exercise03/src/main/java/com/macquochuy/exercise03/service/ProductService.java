package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Product;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(UuidGenerator productId);

    List<Product> getAllProducts();

    Product updateProduct(Product product);
    
    void deleteProduct(UuidGenerator productId);
}