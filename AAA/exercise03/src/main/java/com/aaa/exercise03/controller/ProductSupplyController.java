package com.aaa.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aaa.exercise03.entity.ProductSupplier;
import com.aaa.exercise03.service.ProductSupplyService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/product-supplies")
public class ProductSupplyController {

    private ProductSupplyService productSupplyService;

    // Create ProductSupplier REST API
    @PostMapping
    public ResponseEntity<ProductSupplier> createProductSupply(@RequestBody ProductSupplier productSupply) {
        ProductSupplier savedProductSupply = productSupplyService.createProductSupply(productSupply);
        return new ResponseEntity<>(savedProductSupply, HttpStatus.CREATED);
    }

    // Get ProductSupplier by id REST API
    // http://localhost:8080/api/product-supplies/{id}
    @GetMapping("{id}")
    public ResponseEntity<ProductSupplier> getProductSupplyById(@PathVariable("id") UUID productSupplyId) {
        ProductSupplier productSupply = productSupplyService.getProductSupplyById(productSupplyId);
        return new ResponseEntity<>(productSupply, HttpStatus.OK);
    }

    // Get All ProductSupplies REST API
    // http://localhost:8080/api/product-supplies
    @GetMapping
    public ResponseEntity<List<ProductSupplier>> getAllProductSupplies() {
        List<ProductSupplier> productSupplies = productSupplyService.getAllProductSupplys();
        return new ResponseEntity<>(productSupplies, HttpStatus.OK);
    }

    // Update ProductSupplier REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/product-supplies/{id}
    public ResponseEntity<ProductSupplier> updateProductSupply(@PathVariable("id") UUID productSupplyId,
                                                  @RequestBody ProductSupplier productSupply) {
        productSupply.setId(productSupplyId);
        ProductSupplier updatedProductSupply = productSupplyService.updateProductSupply(productSupply);
        if (updatedProductSupply != null) {
            return new ResponseEntity<>(updatedProductSupply, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete ProductSupplier REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductSupply(@PathVariable("id") UUID productSupplyId) {
        productSupplyService.deleteProductSupply(productSupplyId);
        return new ResponseEntity<>("ProductSupplier successfully deleted!", HttpStatus.OK);
    }
}
