package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.VariantValue;

public interface VariantValueService {

    VariantValue createVariantValue(VariantValue variantValue);

    VariantValue getVariantValueById(UuidGenerator variantValueId);

    List<VariantValue> getAllVariantValues();

    VariantValue updateVariantValue(VariantValue variantValue);
    
    void deleteVariantValue(UuidGenerator variantValueId);
}