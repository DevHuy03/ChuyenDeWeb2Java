package com.aaa.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.ProductTag;

public interface ProductTagService {

    ProductTag createProductTag(ProductTag productTag);

    ProductTag getProductTagById(UUID productTagId);

    List<ProductTag> getAllProductTags();

    ProductTag updateProductTag(ProductTag productTag);
    
    void deleteProductTag(UUID productTagId);
}