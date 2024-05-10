package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.VariantOption;
import com.macquochuy.exercise03.Repository.VariantOptionRepository;
import com.macquochuy.exercise03.service.VariantOptionService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VariantOptionServiceImpl implements VariantOptionService {
    private VariantOptionRepository variantOptionRepository;

    @Override
    public VariantOption createVariantOption(VariantOption variantOption) {
        return variantOptionRepository.save(variantOption);
    }

    @Override
    public VariantOption getVariantOptionById(UuidGenerator variantOptionId) {
        Optional<VariantOption> optionalVariantOption = variantOptionRepository.findById(variantOptionId);
        return optionalVariantOption.orElse(null);
    }

    @Override
    public List<VariantOption> getAllVariantOptions() {
        return variantOptionRepository.findAll();
    }

    @Override
    public VariantOption updateVariantOption(VariantOption variantOption) {
        Optional<VariantOption> optionalExistingVariantOption = variantOptionRepository.findById(variantOption.getId());
        if (optionalExistingVariantOption.isPresent()) {
            VariantOption existingVariantOption = optionalExistingVariantOption.get();
            existingVariantOption.setTitle(variantOption.getTitle());
            existingVariantOption.setImage_id(variantOption.getImage_id());
            existingVariantOption.setProduct_id(variantOption.getProduct_id());
            existingVariantOption.setSale_price(variantOption.getSale_price());
            existingVariantOption.setCompare_price(variantOption.getCompare_price());
            existingVariantOption.setBuying_price(variantOption.getBuying_price());
            existingVariantOption.setQuantity(variantOption.getQuantity());
            existingVariantOption.setSku(variantOption.getSku());
            existingVariantOption.setActive(variantOption.isActive());

            VariantOption updatedVariantOption = variantOptionRepository.save(existingVariantOption);
            return updatedVariantOption;
        }

        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy tùy chọn biến thể tồn tại
    }

    @Override
    public void deleteVariantOption(UuidGenerator variantOptionId) {
        variantOptionRepository.deleteById(variantOptionId);
    }
}
