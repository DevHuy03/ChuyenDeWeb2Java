package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.ProductAttribute;

public interface ProductAttributeService {

    ProductAttribute createProductAttribute(ProductAttribute productAttribute);

    ProductAttribute getProductAttributeById(UUID productAttributeId);

    List<ProductAttribute> getAllProductAttributes();

    ProductAttribute updateProductAttribute(ProductAttribute productAttribute);
    
    void deleteProductAttribute(UUID productAttributeId);
}