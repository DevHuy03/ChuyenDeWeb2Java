package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.ShippingRate;

public interface ShippingRateService {
    
    ShippingRate createShippingRate(ShippingRate shippingRate);

    ShippingRate getShippingRateById(UUID shippingRateId);

    List<ShippingRate> getAllShippingRates();

    ShippingRate updateShippingRate(ShippingRate shippingRate);
    
    void deleteShippingRate(UUID shippingRateId);
}