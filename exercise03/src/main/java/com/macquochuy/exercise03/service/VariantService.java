package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Variant;

public interface VariantService {

    Variant createVariant(Variant variant);

    Variant getVariantById(UuidGenerator variantId);

    List<Variant> getAllVariants();

    Variant updateVariant(Variant variant);
    
    void deleteVariant(UuidGenerator variantId);
}