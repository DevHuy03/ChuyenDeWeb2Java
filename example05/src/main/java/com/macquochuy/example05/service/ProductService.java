package com.macquochuy.example05.service;

import java.util.List;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import com.macquochuy.example05.entity.Product;
public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Long productId);

    List<Product> getAllProducts();
    // Page<Product> getAllProducts(Pageable pageable);

    Product updateProduct(Product product);

    void deleteProduct(Long productId);    
} 
