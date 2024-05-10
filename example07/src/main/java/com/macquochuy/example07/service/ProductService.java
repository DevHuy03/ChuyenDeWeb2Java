package com.macquochuy.example07.service; 
 import java.util.List; 
 import com.macquochuy.example07.entity.Product; 
 
public interface ProductService { 

    Product createProduct(Product product); 

    Product getProductById(Long productId); 

    List<Product> getAllProducts(); 

    Product updateProduct(Product product); 
    
    void deleteProduct(Long productId); 
} 
