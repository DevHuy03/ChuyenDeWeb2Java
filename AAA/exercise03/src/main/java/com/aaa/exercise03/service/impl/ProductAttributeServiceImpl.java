package com.aaa.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.aaa.exercise03.Repository.ProductAttributeRepository;
import com.aaa.exercise03.entity.ProductAttribute;
import com.aaa.exercise03.service.ProductAttributeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductAttributeServiceImpl implements ProductAttributeService {
    private ProductAttributeRepository productAttributeRepository;

    @Override
    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }

    @Override
    public ProductAttribute getProductAttributeById(UUID productAttributeId) {
        Optional<ProductAttribute> optionalProductAttribute = productAttributeRepository.findById(productAttributeId);
        return optionalProductAttribute.orElse(null);
    }

    @Override
    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeRepository.findAll();
    }

    @Override
    public ProductAttribute updateProductAttribute(ProductAttribute productAttribute) {
        Optional<ProductAttribute> optionalExistingProductAttribute = productAttributeRepository.findById(productAttribute.getId());
        if (optionalExistingProductAttribute.isPresent()) {
            ProductAttribute existingProductAttribute = optionalExistingProductAttribute.get();
            existingProductAttribute.setProduct_id(productAttribute.getProduct_id());
            existingProductAttribute.setAttribute_id(productAttribute.getAttribute_id());

            ProductAttribute updatedProductAttribute = productAttributeRepository.save(existingProductAttribute);
            return updatedProductAttribute;
        }

        return null;
    }

    @Override
    public void deleteProductAttribute(UUID productAttributeId) {
        productAttributeRepository.deleteById(productAttributeId);
    }
}
