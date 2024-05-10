package com.aaa.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.aaa.exercise03.entity.ProductShippingInfo;

public interface ProductShippingInfoService {

    ProductShippingInfo createProductShippingInfo(ProductShippingInfo productShippingInfo);

    ProductShippingInfo getProductShippingInfoById(UUID productShippingInfoId);

    List<ProductShippingInfo> getAllProductShippingInfos();

    ProductShippingInfo updateProductShippingInfo(ProductShippingInfo productShippingInfo);
    
    void deleteProductShippingInfo(UUID productShippingInfoId);
}