package com.macquochuy.exercise03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise03.entity.Coupon;

import java.util.UUID;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, UUID> {
}
