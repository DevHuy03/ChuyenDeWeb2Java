package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.ProductAttributeValue;

public interface ProductAttributeValueService {

    ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue);

    ProductAttributeValue getProductAttributeValueById(UuidGenerator productAttributeValueId);

    List<ProductAttributeValue> getAllProductAttributeValues();

    ProductAttributeValue updateProductAttributeValue(ProductAttributeValue productAttributeValue);
    
    void deleteProductAttributeValue(UuidGenerator productAttributeValueId);
}