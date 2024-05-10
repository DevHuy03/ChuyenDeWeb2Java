package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.VariantOption;

public interface VariantOptionService {

    VariantOption createVariantOption(VariantOption variantOption);

    VariantOption getVariantOptionById(UuidGenerator variantOptionId);

    List<VariantOption> getAllVariantOptions();

    VariantOption updateVariantOption(VariantOption variantOption);
    
    void deleteVariantOption(UuidGenerator variantOptionId);
}