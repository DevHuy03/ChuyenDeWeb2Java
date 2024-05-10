package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Product;
import com.macquochuy.exercise03.Repository.ProductRepository;
import com.macquochuy.exercise03.service.ProductService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public Product getProductById(UuidGenerator productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> optionalExistingProduct = productRepository.findById(product.getId());
        if (optionalExistingProduct.isPresent()) {
            Product existingProduct = optionalExistingProduct.get();
            existingProduct.setSlug(product.getSlug());
            existingProduct.setProduct_name(product.getProduct_name());
            existingProduct.setSku(product.getSku());
            existingProduct.setSale_price(product.getSale_price());
            existingProduct.setCompare_price(product.getCompare_price());
            existingProduct.setBuying_price(product.getBuying_price());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setShort_description(product.getShort_description());
            existingProduct.setProduct_description(product.getProduct_description());
            existingProduct.setProduct_type(product.getProduct_type());
            existingProduct.setPublished(product.isPublished());
            existingProduct.setDisable_out_of_stock(product.isDisable_out_of_stock());
            existingProduct.setNote(product.getNote());
            existingProduct.setCreated_by(product.getCreated_by());
            existingProduct.setUpdated_by(product.getUpdated_by());

            Product updatedProduct = productRepository.save(existingProduct);
            return updatedProduct;
        }

        return null;
    }

    @Override
    public void deleteProduct(UuidGenerator productId) {
        productRepository.deleteById(productId);
    }
}
