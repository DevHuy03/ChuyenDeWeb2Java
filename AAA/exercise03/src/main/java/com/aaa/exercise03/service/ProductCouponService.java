package com.aaa.exercise03.service;
import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.ProductCoupon;

public interface ProductCouponService {

    ProductCoupon createProductCoupon(ProductCoupon productCoupon);

    ProductCoupon getProductCouponById(UUID productCouponId);

    List<ProductCoupon> getAllProductCoupons();
    
    ProductCoupon updateProductCoupon(ProductCoupon productCoupon);

    void deleteProductCoupon(UUID productCouponId);
}