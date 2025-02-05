package com.macquochuy.exercise02.service;
import java.util.List;

import com.macquochuy.exercise02.Entity.Product;
public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long productId);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    void deleteProduct(Long productId);
}
