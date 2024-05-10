package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Coupon;
import com.macquochuy.exercise03.Repository.CouponRepository;
import com.macquochuy.exercise03.service.CouponService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CouponServiceImpl implements CouponService {
    private CouponRepository couponRepository;

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon getCouponById(UUID couponId) {
        Optional<Coupon> optionalCoupon = couponRepository.findById(couponId);
        return optionalCoupon.orElse(null);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        Optional<Coupon> optionalExistingCoupon = couponRepository.findById(coupon.getId());
        if (optionalExistingCoupon.isPresent()) {
            Coupon existingCoupon = optionalExistingCoupon.get();
            existingCoupon.setCode(coupon.getCode());
            existingCoupon.setDiscount_value(coupon.getDiscount_value());
            existingCoupon.setDiscount_type(coupon.getDiscount_type());
            existingCoupon.setTimes_used(coupon.getTimes_used());
            existingCoupon.setMax_usage(coupon.getMax_usage());
            existingCoupon.setOrder_amount_limit(coupon.getOrder_amount_limit());
            existingCoupon.setCoupon_start_date(new Date());
            existingCoupon.setCoupon_end_date(new Date());
            existingCoupon.setUpdated_at(new Date());
            Coupon updatedCoupon = couponRepository.save(existingCoupon);
            return updatedCoupon;
        }

        return null;
    }

    @Override
    public void deleteCoupon(UUID couponId) {
        couponRepository.deleteById(couponId);
    }
}
