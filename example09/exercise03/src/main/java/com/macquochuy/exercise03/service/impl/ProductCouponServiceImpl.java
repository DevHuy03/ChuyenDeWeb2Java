package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.ProductCoupon;
import com.macquochuy.exercise03.Repository.ProductCouponRepository;
import com.macquochuy.exercise03.service.ProductCouponService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductCouponServiceImpl implements ProductCouponService {
    private ProductCouponRepository productCouponRepository;

    @Override
    public ProductCoupon createProductCoupon(ProductCoupon productCoupon) {
        return productCouponRepository.save(productCoupon);
    }

    @Override
    public ProductCoupon getProductCouponById(UUID productCouponId) {
        Optional<ProductCoupon> optionalProductCoupon = productCouponRepository.findById(productCouponId);
        return optionalProductCoupon.orElse(null);
    }

    @Override
    public List<ProductCoupon> getAllProductCoupons() {
        return productCouponRepository.findAll();
    }

    @Override
    public ProductCoupon updateProductCoupon(ProductCoupon productCoupon) {
        Optional<ProductCoupon> optionalExistingProductCoupon = productCouponRepository.findById(productCoupon.getId());
        if (optionalExistingProductCoupon.isPresent()) {
            ProductCoupon existingProductCoupon = optionalExistingProductCoupon.get();
            existingProductCoupon.setProduct_id(productCoupon.getProduct_id());
            existingProductCoupon.setCoupon_id(productCoupon.getCoupon_id());

            ProductCoupon updatedProductCoupon = productCouponRepository.save(existingProductCoupon);
            return updatedProductCoupon;
        }

        return null;
    }

    @Override
    public void deleteProductCoupon(UUID productCouponId) {
        productCouponRepository.deleteById(productCouponId);
    }
}
