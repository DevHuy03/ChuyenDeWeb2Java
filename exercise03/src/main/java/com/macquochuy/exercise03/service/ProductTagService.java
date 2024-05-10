package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.ProductTag;

public interface ProductTagService {

    ProductTag createProductTag(ProductTag productTag);

    ProductTag getProductTagById(UuidGenerator productTagId);

    List<ProductTag> getAllProductTags();

    ProductTag updateProductTag(ProductTag productTag);
    
    void deleteProductTag(UuidGenerator productTagId);
}