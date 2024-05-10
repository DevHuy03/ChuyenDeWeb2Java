package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.ShippingCountryZone;

public interface ShippingCountryZoneService {

    ShippingCountryZone createShippingCountry(ShippingCountryZone shippingcountryzore);

    ShippingCountryZone getShippingCountryById(UuidGenerator shippingcountryzoreId);

    List<ShippingCountryZone> getAllShippingCountrys();

    ShippingCountryZone updateShippingCountry(ShippingCountryZone shippingcountryzore);

    void deleteShippingCountry(UuidGenerator shippingcountryzoreId);
}