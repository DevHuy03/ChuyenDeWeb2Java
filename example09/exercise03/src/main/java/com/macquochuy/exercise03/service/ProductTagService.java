package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.ProductTag;


public interface ProductTagService {

    ProductTag createProductTag(ProductTag productTag);

    ProductTag getProductTagById(UUID productTagId);

    List<ProductTag> getAllProductTag();

    ProductTag updateProductTag(ProductTag productTag);
    
    void deleteProductTag(UUID productTagId);
}