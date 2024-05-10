package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.ProductCoupon;
import com.macquochuy.exercise03.service.ProductCouponService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/productCoupons")
public class ProductCouponController {

    private ProductCouponService productCouponService;

    // Create ProductCoupon REST API
    @PostMapping
    public ResponseEntity<ProductCoupon> createProductCoupon(@RequestBody ProductCoupon productCoupon) {
        ProductCoupon savedProductCoupon = productCouponService.createProductCoupon(productCoupon);
        return new ResponseEntity<>(savedProductCoupon, HttpStatus.CREATED);
    }

    // Get ProductCoupon by id REST API
    // http://localhost:8080/api/productCoupons/{id}
    @GetMapping("{id}")
    public ResponseEntity<ProductCoupon> getProductCouponById(@PathVariable("id") UuidGenerator productCouponId) {
        ProductCoupon productCoupon = productCouponService.getProductCouponById(productCouponId);
        return new ResponseEntity<>(productCoupon, HttpStatus.OK);
    }

    // Get All ProductCoupons REST API
    // http://localhost:8080/api/productCoupons
    @GetMapping
    public ResponseEntity<List<ProductCoupon>> getAllProductCoupons() {
        List<ProductCoupon> productCoupons = productCouponService.getAllProductCoupons();
        return new ResponseEntity<>(productCoupons, HttpStatus.OK);
    }

    // Update ProductCoupon REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/productCoupons/{id}
    public ResponseEntity<ProductCoupon> updateProductCoupon(@PathVariable("id") UuidGenerator productCouponId,
                                                              @RequestBody ProductCoupon productCoupon) {
        productCoupon.setId(productCouponId);
        ProductCoupon updatedProductCoupon = productCouponService.updateProductCoupon(productCoupon);
        if (updatedProductCoupon != null) {
            return new ResponseEntity<>(updatedProductCoupon, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete ProductCoupon REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductCoupon(@PathVariable("id") UuidGenerator productCouponId) {
        productCouponService.deleteProductCoupon(productCouponId);
        return new ResponseEntity<>("ProductCoupon successfully deleted!", HttpStatus.OK);
    }
}
