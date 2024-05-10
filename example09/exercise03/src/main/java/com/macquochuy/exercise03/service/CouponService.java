package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.Coupon;

public interface CouponService {

    Coupon createCoupon(Coupon coupon);

    Coupon getCouponById(UUID couponId);

    List<Coupon> getAllCoupons();

    Coupon updateCoupon(Coupon coupon);
    
    void deleteCoupon(UUID couponId);
}