package com.aaa.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.aaa.exercise03.Repository.ShippingRateRepository;
import com.aaa.exercise03.entity.ShippingRate;
import com.aaa.exercise03.service.ShippingRateService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShippingRateServiceImpl implements ShippingRateService {
    private ShippingRateRepository shippingRateRepository;

    @Override
    public ShippingRate createShippingRate(ShippingRate shippingRate) {
        return shippingRateRepository.save(shippingRate);
    }

    @Override
    public ShippingRate getShippingRateById(UUID shippingRateId) {
        Optional<ShippingRate> optionalShippingRate = shippingRateRepository.findById(shippingRateId);
        return optionalShippingRate.orElse(null);
    }

    @Override
    public List<ShippingRate> getAllShippingRates() {
        return shippingRateRepository.findAll();
    }

    @Override
    public ShippingRate updateShippingRate(ShippingRate shippingRate) {
        Optional<ShippingRate> optionalExistingShippingRate = shippingRateRepository.findById(shippingRate.getId());
        if (optionalExistingShippingRate.isPresent()) {
            ShippingRate existingShippingRate = optionalExistingShippingRate.get();
            existingShippingRate.setShipping_zone_id(shippingRate.getShipping_zone_id());
            existingShippingRate.setWeight_unit(shippingRate.getWeight_unit());
            existingShippingRate.setMin_value(shippingRate.getMin_value());
            existingShippingRate.setMax_value(shippingRate.getMax_value());
            existingShippingRate.setNo_max(shippingRate.isNo_max());
            existingShippingRate.setPrice(shippingRate.getPrice());

            ShippingRate updatedShippingRate = shippingRateRepository.save(existingShippingRate);
            return updatedShippingRate;
        }

        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy tỉ lệ vận chuyển tồn tại
    }

    @Override
    public void deleteShippingRate(UUID shippingRateId) {
        shippingRateRepository.deleteById(shippingRateId);
    }
}
