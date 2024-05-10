package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.Variant;

public interface VariantService {

    Variant createVariant(Variant variant);

    Variant getVariantById(UUID variantId);

    List<Variant> getAllVariants();

    Variant updateVariant(Variant variant);
    
    void deleteVariant(UUID variantId);
}