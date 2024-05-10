package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.ShippingCountryZone;

public interface ShippingCountryZoneService {

    ShippingCountryZone createShippingCountry(ShippingCountryZone shippingcountryzore);

    ShippingCountryZone getShippingCountryById(UUID shippingcountryzoreId);

    List<ShippingCountryZone> getAllShippingCountrys();

    ShippingCountryZone updateShippingCountry(ShippingCountryZone shippingcountryzore);

    void deleteShippingCountry(UUID shippingcountryzoreId);
}