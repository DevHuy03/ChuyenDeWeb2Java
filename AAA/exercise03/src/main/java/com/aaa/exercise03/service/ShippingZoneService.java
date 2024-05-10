package com.aaa.exercise03.service;

import java.util.List;

import com.aaa.exercise03.entity.ShippingZone;

public interface ShippingZoneService {

    ShippingZone createShipping(ShippingZone shipping);

    ShippingZone getShippingById(Integer shippingId);

    List<ShippingZone> getAllShippings();

    ShippingZone updateShipping(ShippingZone shipping);

    void deleteShipping(Integer shippingId);
}