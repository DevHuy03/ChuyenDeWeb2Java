package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.ShippingRate;

public interface ShippingRateService {
    
    ShippingRate createShippingRate(ShippingRate shippingRate);

    ShippingRate getShippingRateById(UuidGenerator shippingRateId);

    List<ShippingRate> getAllShippingRates();

    ShippingRate updateShippingRate(ShippingRate shippingRate);
    
    void deleteShippingRate(UuidGenerator shippingRateId);
}