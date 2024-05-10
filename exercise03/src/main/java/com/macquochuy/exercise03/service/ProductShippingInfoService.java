package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.ProductShippingInfo;

public interface ProductShippingInfoService {

    ProductShippingInfo createProductShippingInfo(ProductShippingInfo productShippingInfo);

    ProductShippingInfo getProductShippingInfoById(UuidGenerator productShippingInfoId);

    List<ProductShippingInfo> getAllProductShippingInfos();

    ProductShippingInfo updateProductShippingInfo(ProductShippingInfo productShippingInfo);
    
    void deleteProductShippingInfo(UuidGenerator productShippingInfoId);
}