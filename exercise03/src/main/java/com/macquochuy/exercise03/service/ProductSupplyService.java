package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.ProductSupplier;

public interface ProductSupplyService {

    ProductSupplier createProductSupply(ProductSupplier product);

    ProductSupplier getProductSupplyById(UuidGenerator productId);

    List<ProductSupplier> getAllProductSupplys();

    ProductSupplier updateProductSupply(ProductSupplier product);

    void deleteProductSupply(UuidGenerator productId);
    
}