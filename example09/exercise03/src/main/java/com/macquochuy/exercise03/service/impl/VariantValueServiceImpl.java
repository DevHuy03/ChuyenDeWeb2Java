package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.VariantValue;
import com.macquochuy.exercise03.Repository.VariantValueRepository;
import com.macquochuy.exercise03.service.VariantValueService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VariantValueServiceImpl implements VariantValueService {
    private VariantValueRepository variantValueRepository;

    @Override
    public VariantValue createVariantValue(VariantValue variantValue) {
        return variantValueRepository.save(variantValue);
    }

    @Override
    public VariantValue getVariantValueById(UUID variantValueId) {
        Optional<VariantValue> optionalVariantValue = variantValueRepository.findById(variantValueId);
        return optionalVariantValue.orElse(null);
    }

    @Override
    public List<VariantValue> getAllVariantValues() {
        return variantValueRepository.findAll();
    }

    @Override
    public VariantValue updateVariantValue(VariantValue variantValue) {
        Optional<VariantValue> optionalExistingVariantValue = variantValueRepository.findById(variantValue.getId());
        if (optionalExistingVariantValue.isPresent()) {
            VariantValue existingVariantValue = optionalExistingVariantValue.get();
            existingVariantValue.setVariant_id(variantValue.getVariant_id());
            existingVariantValue.setProduct_attribute_value_id(variantValue.getProduct_attribute_value_id());

            VariantValue updatedVariantValue = variantValueRepository.save(existingVariantValue);
            return updatedVariantValue;
        }

        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy giá trị biến thể tồn tại
    }

    @Override
    public void deleteVariantValue(UUID variantValueId) {
        variantValueRepository.deleteById(variantValueId);
    }
}
