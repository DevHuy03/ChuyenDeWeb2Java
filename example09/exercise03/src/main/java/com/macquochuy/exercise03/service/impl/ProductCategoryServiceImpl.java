package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.ProductCategory;
import com.macquochuy.exercise03.Repository.ProductCategoryRepository;
import com.macquochuy.exercise03.service.ProductCategoryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory getProductCategoryById(UUID productCategoryId) {
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findById(productCategoryId);
        return optionalProductCategory.orElse(null);
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        Optional<ProductCategory> optionalExistingProductCategory = productCategoryRepository.findById(productCategory.getId());
        if (optionalExistingProductCategory.isPresent()) {
            ProductCategory existingProductCategory = optionalExistingProductCategory.get();
            existingProductCategory.setProduct_id(productCategory.getProduct_id());
            existingProductCategory.setCategory_id(productCategory.getCategory_id());

            ProductCategory updatedProductCategory = productCategoryRepository.save(existingProductCategory);
            return updatedProductCategory;
        }

        return null;
    }

    @Override
    public void deleteProductCategory(UUID productCategoryId) {
        productCategoryRepository.deleteById(productCategoryId);
    }
}
