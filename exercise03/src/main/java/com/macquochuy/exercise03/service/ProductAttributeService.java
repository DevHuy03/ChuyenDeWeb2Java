package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.ProductAttribute;

public interface ProductAttributeService {

    ProductAttribute createProductAttribute(ProductAttribute productAttribute);

    ProductAttribute getProductAttributeById(UuidGenerator productAttributeId);

    List<ProductAttribute> getAllProductAttributes();

    ProductAttribute updateProductAttribute(ProductAttribute productAttribute);
    
    void deleteProductAttribute(UuidGenerator productAttributeId);
}