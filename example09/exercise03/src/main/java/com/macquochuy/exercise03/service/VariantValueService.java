package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.VariantValue;

public interface VariantValueService {

    VariantValue createVariantValue(VariantValue variantValue);

    VariantValue getVariantValueById(UUID variantValueId);

    List<VariantValue> getAllVariantValues();

    VariantValue updateVariantValue(VariantValue variantValue);
    
    void deleteVariantValue(UUID variantValueId);
}