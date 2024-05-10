package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.ProductAttributeValue;
import com.macquochuy.exercise03.Repository.ProductAttributeValueRepository;
import com.macquochuy.exercise03.service.ProductAttributeValueService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {
    private ProductAttributeValueRepository productAttributeValueRepository;

    @Override
    public ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue) {
        return productAttributeValueRepository.save(productAttributeValue);
    }

    @Override
    public ProductAttributeValue getProductAttributeValueById(UUID productAttributeValueId) {
        Optional<ProductAttributeValue> optionalProductAttributeValue = productAttributeValueRepository.findById(productAttributeValueId);
        return optionalProductAttributeValue.orElse(null);
    }

    @Override
    public List<ProductAttributeValue> getAllProductAttributeValues() {
        return productAttributeValueRepository.findAll();
    }

    @Override
    public ProductAttributeValue updateProductAttributeValue(ProductAttributeValue productAttributeValue) {
        Optional<ProductAttributeValue> optionalExistingProductAttributeValue = productAttributeValueRepository.findById(productAttributeValue.getId());
        if (optionalExistingProductAttributeValue.isPresent()) {
            ProductAttributeValue existingProductAttributeValue = optionalExistingProductAttributeValue.get();
            existingProductAttributeValue.setProduct_attribute_id(productAttributeValue.getProduct_attribute_id());
            existingProductAttributeValue.setAttribute_value_id(productAttributeValue.getAttribute_value_id());

            ProductAttributeValue updatedProductAttributeValue = productAttributeValueRepository.save(existingProductAttributeValue);
            return updatedProductAttributeValue;
        }

        return null;
    }

    @Override
    public void deleteProductAttributeValue(UUID productAttributeValueId) {
        productAttributeValueRepository.deleteById(productAttributeValueId);
    }
}
