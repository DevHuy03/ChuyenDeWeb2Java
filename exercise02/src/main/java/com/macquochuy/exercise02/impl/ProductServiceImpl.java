package com.macquochuy.exercise02.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.Product;
import com.macquochuy.exercise02.Repository.ProductRepository;
import com.macquochuy.exercise02.service.ProductService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
      
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> optionalExistingProduct = productRepository.findById(product.getProduct_id());

        if (optionalExistingProduct.isPresent()) {
            Product existingProduct = optionalExistingProduct.get();
            existingProduct.setProduct_title(product.getProduct_title());
            existingProduct.setImage_url(product.getImage_url());
            existingProduct.setSku(product.getSku());
            existingProduct.setPrice_unit(product.getPrice_unit());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setLikes(product.getLikes());
            existingProduct.setOrderItems(product.getOrderItems());
            existingProduct.setUpdated_at(product.getUpdated_at());

            return productRepository.save(existingProduct);
        } else {
            // Trả về null nếu sản phẩm không tồn tại
            return null;
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
