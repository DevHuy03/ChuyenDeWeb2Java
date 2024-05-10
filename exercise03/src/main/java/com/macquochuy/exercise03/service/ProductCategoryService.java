package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.ProductCategory;

public interface ProductCategoryService {

    ProductCategory createProductCategory(ProductCategory productCategory);

    ProductCategory getProductCategoryById(UuidGenerator productCategoryId);

    List<ProductCategory> getAllProductCategories();

    ProductCategory updateProductCategory(ProductCategory productCategory);
    
    void deleteProductCategory(UuidGenerator productCategoryId);
}