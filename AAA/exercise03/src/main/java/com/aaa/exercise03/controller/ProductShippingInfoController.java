package com.aaa.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aaa.exercise03.entity.ProductShippingInfo;
import com.aaa.exercise03.service.ProductShippingInfoService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/productShippingInfos")
public class ProductShippingInfoController {

    private ProductShippingInfoService productShippingInfoService;

    // Create ProductShippingInfo REST API
    @PostMapping
    public ResponseEntity<ProductShippingInfo> createProductShippingInfo(@RequestBody ProductShippingInfo productShippingInfo) {
        ProductShippingInfo savedProductShippingInfo = productShippingInfoService.createProductShippingInfo(productShippingInfo);
        return new ResponseEntity<>(savedProductShippingInfo, HttpStatus.CREATED);
    }

    // Get ProductShippingInfo by id REST API
    // http://localhost:8080/api/productShippingInfos/{id}
    @GetMapping("{id}")
    public ResponseEntity<ProductShippingInfo> getProductShippingInfoById(@PathVariable("id") UUID productShippingInfoId) {
        ProductShippingInfo productShippingInfo = productShippingInfoService.getProductShippingInfoById(productShippingInfoId);
        return new ResponseEntity<>(productShippingInfo, HttpStatus.OK);
    }

    // Get All ProductShippingInfos REST API
    // http://localhost:8080/api/productShippingInfos
    @GetMapping
    public ResponseEntity<List<ProductShippingInfo>> getAllProductShippingInfos() {
        List<ProductShippingInfo> productShippingInfos = productShippingInfoService.getAllProductShippingInfos();
        return new ResponseEntity<>(productShippingInfos, HttpStatus.OK);
    }

    // Update ProductShippingInfo REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/productShippingInfos/{id}
    public ResponseEntity<ProductShippingInfo> updateProductShippingInfo(@PathVariable("id") UUID productShippingInfoId,
                                                                          @RequestBody ProductShippingInfo productShippingInfo) {
        productShippingInfo.setId(productShippingInfoId);
        ProductShippingInfo updatedProductShippingInfo = productShippingInfoService.updateProductShippingInfo(productShippingInfo);
        if (updatedProductShippingInfo != null) {
            return new ResponseEntity<>(updatedProductShippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete ProductShippingInfo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductShippingInfo(@PathVariable("id") UUID productShippingInfoId) {
        productShippingInfoService.deleteProductShippingInfo(productShippingInfoId);
        return new ResponseEntity<>("ProductShippingInfo successfully deleted!", HttpStatus.OK);
    }
}
