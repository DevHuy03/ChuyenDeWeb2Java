package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.ProductShippingInfo;
import com.macquochuy.exercise03.Repository.ProductShippingInfoRepository;
import com.macquochuy.exercise03.service.ProductShippingInfoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductShippingInfoServiceImpl implements ProductShippingInfoService {
    private ProductShippingInfoRepository productShippingInfoRepository;

    @Override
    public ProductShippingInfo createProductShippingInfo(ProductShippingInfo productShippingInfo) {
        return productShippingInfoRepository.save(productShippingInfo);
    }

    @Override
    public ProductShippingInfo getProductShippingInfoById(UUID productShippingInfoId) {
        Optional<ProductShippingInfo> optionalProductShippingInfo = productShippingInfoRepository.findById(productShippingInfoId);
        return optionalProductShippingInfo.orElse(null);
    }

    @Override
    public List<ProductShippingInfo> getAllProductShippingInfos() {
        return productShippingInfoRepository.findAll();
    }

    @Override
    public ProductShippingInfo updateProductShippingInfo(ProductShippingInfo productShippingInfo) {
        Optional<ProductShippingInfo> optionalExistingProductShippingInfo = productShippingInfoRepository.findById(productShippingInfo.getId());
        if (optionalExistingProductShippingInfo.isPresent()) {
            ProductShippingInfo existingProductShippingInfo = optionalExistingProductShippingInfo.get();
            existingProductShippingInfo.setProduct_id(productShippingInfo.getProduct_id());
            existingProductShippingInfo.setWeight(productShippingInfo.getWeight());
            existingProductShippingInfo.setWeight_unit(productShippingInfo.getWeight_unit());
            existingProductShippingInfo.setVolume(productShippingInfo.getVolume());
            existingProductShippingInfo.setVolume_unit(productShippingInfo.getVolume_unit());
            existingProductShippingInfo.setDimension_width(productShippingInfo.getDimension_width());
            existingProductShippingInfo.setDimension_height(productShippingInfo.getDimension_height());
            existingProductShippingInfo.setDimension_depth(productShippingInfo.getDimension_depth());
            existingProductShippingInfo.setDimension_unit(productShippingInfo.getDimension_unit());

            ProductShippingInfo updatedProductShippingInfo = productShippingInfoRepository.save(existingProductShippingInfo);
            return updatedProductShippingInfo;
        }

        return null;
    }

    @Override
    public void deleteProductShippingInfo(UUID productShippingInfoId) {
        productShippingInfoRepository.deleteById(productShippingInfoId);
    }
}
