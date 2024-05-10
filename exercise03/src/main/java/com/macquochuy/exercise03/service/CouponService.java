package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Coupon;

public interface CouponService {

    Coupon createCoupon(Coupon coupon);

    Coupon getCouponById(UuidGenerator couponId);

    List<Coupon> getAllCoupons();

    Coupon updateCoupon(Coupon coupon);
    
    void deleteCoupon(UuidGenerator couponId);
}