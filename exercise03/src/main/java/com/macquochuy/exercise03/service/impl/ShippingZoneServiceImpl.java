package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.ShippingZone;
import com.macquochuy.exercise03.Repository.ShippingZoneRepository;
import com.macquochuy.exercise03.service.ShippingZoneService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShippingZoneServiceImpl implements ShippingZoneService {
    private ShippingZoneRepository shippingRepository;

    @Override
    public ShippingZone createShipping(ShippingZone shipping) {
        return shippingRepository.save(shipping);
    }

    @Override
    public ShippingZone getShippingById(Integer shippingId) {
        Optional<ShippingZone> optionalShipping = shippingRepository.findById(shippingId);
        return optionalShipping.orElse(null);
    }

    @Override
    public List<ShippingZone> getAllShippings() {
        return shippingRepository.findAll();
    }

    @Override
    public ShippingZone updateShipping(ShippingZone shipping) {
        Optional<ShippingZone> optionalExistingShipping = shippingRepository.findById(shipping.getId());
        if (optionalExistingShipping.isPresent()) {
            ShippingZone existingShipping = optionalExistingShipping.get();
            existingShipping.setName(shipping.getName());
            existingShipping.setDisplay_name(shipping.getDisplay_name());
            existingShipping.setActive(shipping.isActive());
            existingShipping.setFree_shipping(shipping.isFree_shipping());
            existingShipping.setRate_type(shipping.getRate_type());
            existingShipping.setUpdated_at(new Date());
            existingShipping.setUpdated_by(shipping.getUpdated_by());

            ShippingZone updatedShipping = shippingRepository.save(existingShipping);
            return updatedShipping;
        }

        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy vận chuyển tồn tại
    }

    @Override
    public void deleteShipping(Integer shippingId) {
        shippingRepository.deleteById(shippingId);
    }
}
