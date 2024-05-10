package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Variant;
import com.macquochuy.exercise03.Repository.VariantRepository;
import com.macquochuy.exercise03.service.VariantService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VariantServiceImpl implements VariantService {
    private VariantRepository variantRepository;

    @Override
    public Variant createVariant(Variant variant) {
        return variantRepository.save(variant);
    }

    @Override
    public Variant getVariantById(UuidGenerator variantId) {
        Optional<Variant> optionalVariant = variantRepository.findById(variantId);
        return optionalVariant.orElse(null);
    }

    @Override
    public List<Variant> getAllVariants() {
        return variantRepository.findAll();
    }

    @Override
    public Variant updateVariant(Variant variant) {
        Optional<Variant> optionalExistingVariant = variantRepository.findById(variant.getId());
        if (optionalExistingVariant.isPresent()) {
            Variant existingVariant = optionalExistingVariant.get();
            existingVariant.setVailant_option(variant.getVailant_option());
            existingVariant.setProduct_id(variant.getProduct_id());
            existingVariant.setVariant_option_id(variant.getVariant_option_id());

            Variant updatedVariant = variantRepository.save(existingVariant);
            return updatedVariant;
        }

        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy biến thể tồn tại
    }

    @Override
    public void deleteVariant(UuidGenerator variantId) {
        variantRepository.deleteById(variantId);
    }
}
