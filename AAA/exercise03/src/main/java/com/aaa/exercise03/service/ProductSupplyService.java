package com.aaa.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.ProductSupplier;

public interface ProductSupplyService {

    ProductSupplier createProductSupply(ProductSupplier product);

    ProductSupplier getProductSupplyById(UUID productId);

    List<ProductSupplier> getAllProductSupplys();

    ProductSupplier updateProductSupply(ProductSupplier product);

    void deleteProductSupply(UUID productId);
    
}