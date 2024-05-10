package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.ShippingCountryZone;
import com.macquochuy.exercise03.Repository.ShippingCountryZoreRepository;
import com.macquochuy.exercise03.service.ShippingCountryZoneService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShippingCountryZoreServiceImpl implements ShippingCountryZoneService {
    private ShippingCountryZoreRepository shippingCountryRepository;

    @Override
    public ShippingCountryZone createShippingCountry(ShippingCountryZone shippingCountry) {
        return shippingCountryRepository.save(shippingCountry);
    }

    @Override
    public ShippingCountryZone getShippingCountryById(UuidGenerator shippingCountryId) {
        Optional<ShippingCountryZone> optionalShippingCountry = shippingCountryRepository.findById(shippingCountryId);
        return optionalShippingCountry.orElse(null);
    }

    @Override
    public List<ShippingCountryZone> getAllShippingCountrys() {
        return shippingCountryRepository.findAll();
    }

    @Override
    public ShippingCountryZone updateShippingCountry(ShippingCountryZone shippingCountry) {
        Optional<ShippingCountryZone> optionalExistingShippingCountry = shippingCountryRepository.findById(shippingCountry.getId());
        if (optionalExistingShippingCountry.isPresent()) {
            ShippingCountryZone existingShippingCountry = optionalExistingShippingCountry.get();
            existingShippingCountry.setShipping_zone_id(shippingCountry.getShipping_zone_id());
            existingShippingCountry.setCountry_id(shippingCountry.getCountry_id());
            // Update fields accordingly based on your ShippingCountryZore entity

            ShippingCountryZone updatedShippingCountry = shippingCountryRepository.save(existingShippingCountry);
            return updatedShippingCountry;
        }

        return null;
    }

    @Override
    public void deleteShippingCountry(UuidGenerator shippingCountryId) {
        shippingCountryRepository.deleteById(shippingCountryId);
    }
}
