package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.ProductTag;
import com.macquochuy.exercise03.service.ProductTagService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/productTags")
@CrossOrigin(origins = "*")
public class ProductTagController {

    private ProductTagService productTagService;

    // Create ProductTags REST API
    @PostMapping
    public ResponseEntity<ProductTag> createProductTag(@RequestBody ProductTag productTag) {
        ProductTag savedProductTag = productTagService.createProductTag(productTag);
        return new ResponseEntity<>(savedProductTag, HttpStatus.CREATED);
    }

    // Get ProductTag by id REST API
    // http://localhost:8080/api/productTags/{id}
    @GetMapping("{id}")
    public ResponseEntity<ProductTag> getProductTagById(@PathVariable("id") UUID productTagId) {
        ProductTag productTag = productTagService.getProductTagById(productTagId);
        return new ResponseEntity<>(productTag, HttpStatus.OK);
    }

    // Get All ProductTags REST API
    // http://localhost:8080/api/productTags
    @GetMapping
    public ResponseEntity<List<ProductTag>> getAllProductTag() {
        List<ProductTag> productTag = productTagService.getAllProductTag();
        return new ResponseEntity<>(productTag, HttpStatus.OK);
    }

    // Update ProductTags REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/productTags/{id}
    public ResponseEntity<ProductTag> updateProductTag(@PathVariable("id") UUID productTagId,
                                                                  @RequestBody ProductTag productTag) {
        productTag.setId(productTagId);
        ProductTag updatedProductTag = productTagService.updateProductTag(productTag);
        if (updatedProductTag != null) {
            return new ResponseEntity<>(updatedProductTag, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete ProductTags REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductTag(@PathVariable("id") UUID productTagId) {
        productTagService.deleteProductTag(productTagId);
        return new ResponseEntity<>("ProductTag successfully deleted!", HttpStatus.OK);
    }
}
