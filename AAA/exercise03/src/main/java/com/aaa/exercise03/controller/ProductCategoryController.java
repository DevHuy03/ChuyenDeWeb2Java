package com.aaa.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aaa.exercise03.entity.ProductCategory;
import com.aaa.exercise03.service.ProductCategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/productCategories")
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;

    // Create ProductCategory REST API
    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory) {
        ProductCategory savedProductCategory = productCategoryService.createProductCategory(productCategory);
        return new ResponseEntity<>(savedProductCategory, HttpStatus.CREATED);
    }

    // Get ProductCategory by id REST API
    // http://localhost:8080/api/productCategories/{id}
    @GetMapping("{id}")
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable("id") UUID productCategoryId) {
        ProductCategory productCategory = productCategoryService.getProductCategoryById(productCategoryId);
        return new ResponseEntity<>(productCategory, HttpStatus.OK);
    }

    // Get All ProductCategories REST API
    // http://localhost:8080/api/productCategories
    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }

    // Update ProductCategory REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/productCategories/{id}
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable("id") UUID productCategoryId,
                                                                  @RequestBody ProductCategory productCategory) {
        productCategory.setId(productCategoryId);
        ProductCategory updatedProductCategory = productCategoryService.updateProductCategory(productCategory);
        if (updatedProductCategory != null) {
            return new ResponseEntity<>(updatedProductCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete ProductCategory REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductCategory(@PathVariable("id") UUID productCategoryId) {
        productCategoryService.deleteProductCategory(productCategoryId);
        return new ResponseEntity<>("ProductCategory successfully deleted!", HttpStatus.OK);
    }
}
