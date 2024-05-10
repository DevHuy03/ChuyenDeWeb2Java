package com.macquochuy.exercise03.service;
import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.ProductCoupon;

public interface ProductCouponService {

    ProductCoupon createProductCoupon(ProductCoupon productCoupon);

    ProductCoupon getProductCouponById(UuidGenerator productCouponId);

    List<ProductCoupon> getAllProductCoupons();
    
    ProductCoupon updateProductCoupon(ProductCoupon productCoupon);

    void deleteProductCoupon(UuidGenerator productCouponId);
}