package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.ProductAttributeValue;

public interface ProductAttributeValueService {

    ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue);

    ProductAttributeValue getProductAttributeValueById(UUID productAttributeValueId);

    List<ProductAttributeValue> getAllProductAttributeValues();

    ProductAttributeValue updateProductAttributeValue(ProductAttributeValue productAttributeValue);
    
    void deleteProductAttributeValue(UUID productAttributeValueId);
}