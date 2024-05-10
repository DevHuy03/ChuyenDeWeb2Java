package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.VariantOption;

public interface VariantOptionService {

    VariantOption createVariantOption(VariantOption variantOption);

    VariantOption getVariantOptionById(UUID variantOptionId);

    List<VariantOption> getAllVariantOptions();

    VariantOption updateVariantOption(VariantOption variantOption);
    
    void deleteVariantOption(UUID variantOptionId);
}