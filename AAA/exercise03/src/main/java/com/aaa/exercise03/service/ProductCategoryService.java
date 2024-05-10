package com.aaa.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.ProductCategory;

public interface ProductCategoryService {

    ProductCategory createProductCategory(ProductCategory productCategory);

    ProductCategory getProductCategoryById(UUID productCategoryId);

    List<ProductCategory> getAllProductCategories();

    ProductCategory updateProductCategory(ProductCategory productCategory);
    
    void deleteProductCategory(UUID productCategoryId);
}