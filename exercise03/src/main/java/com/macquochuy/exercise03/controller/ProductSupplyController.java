package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.ProductSupplier;
import com.macquochuy.exercise03.service.ProductSupplyService;

import java.util.List;

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
    public ResponseEntity<ProductSupplier> getProductSupplyById(@PathVariable("id") UuidGenerator productSupplyId) {
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
    public ResponseEntity<ProductSupplier> updateProductSupply(@PathVariable("id") UuidGenerator productSupplyId,
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
    public ResponseEntity<String> deleteProductSupply(@PathVariable("id") UuidGenerator productSupplyId) {
        productSupplyService.deleteProductSupply(productSupplyId);
        return new ResponseEntity<>("ProductSupplier successfully deleted!", HttpStatus.OK);
    }
}
