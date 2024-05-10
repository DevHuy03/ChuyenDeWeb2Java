package com.aaa.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aaa.exercise03.entity.ProductAttributeValue;
import com.aaa.exercise03.service.ProductAttributeValueService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/productAttributeValues")
public class ProductAttributeValueController {

    private ProductAttributeValueService productAttributeValueService;

    // Create ProductAttributeValue REST API
    @PostMapping
    public ResponseEntity<ProductAttributeValue> createProductAttributeValue(@RequestBody ProductAttributeValue productAttributeValue) {
        ProductAttributeValue savedProductAttributeValue = productAttributeValueService.createProductAttributeValue(productAttributeValue);
        return new ResponseEntity<>(savedProductAttributeValue, HttpStatus.CREATED);
    }

    // Get ProductAttributeValue by id REST API
    // http://localhost:8080/api/productAttributeValues/{id}
    @GetMapping("{id}")
    public ResponseEntity<ProductAttributeValue> getProductAttributeValueById(@PathVariable("id") UUID productAttributeValueId) {
        ProductAttributeValue productAttributeValue = productAttributeValueService.getProductAttributeValueById(productAttributeValueId);
        return new ResponseEntity<>(productAttributeValue, HttpStatus.OK);
    }

    // Get All ProductAttributeValues REST API
    // http://localhost:8080/api/productAttributeValues
    @GetMapping
    public ResponseEntity<List<ProductAttributeValue>> getAllProductAttributeValues() {
        List<ProductAttributeValue> productAttributeValues = productAttributeValueService.getAllProductAttributeValues();
        return new ResponseEntity<>(productAttributeValues, HttpStatus.OK);
    }

    // Update ProductAttributeValue REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/productAttributeValues/{id}
    public ResponseEntity<ProductAttributeValue> updateProductAttributeValue(@PathVariable("id") UUID productAttributeValueId,
                                                                              @RequestBody ProductAttributeValue productAttributeValue) {
        productAttributeValue.setId(productAttributeValueId);
        ProductAttributeValue updatedProductAttributeValue = productAttributeValueService.updateProductAttributeValue(productAttributeValue);
        if (updatedProductAttributeValue != null) {
            return new ResponseEntity<>(updatedProductAttributeValue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete ProductAttributeValue REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductAttributeValue(@PathVariable("id") UUID productAttributeValueId) {
        productAttributeValueService.deleteProductAttributeValue(productAttributeValueId);
        return new ResponseEntity<>("ProductAttributeValue successfully deleted!", HttpStatus.OK);
    }
}
