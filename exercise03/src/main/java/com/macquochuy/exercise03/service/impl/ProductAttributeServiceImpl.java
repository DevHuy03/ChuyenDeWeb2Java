package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.ProductAttribute;
import com.macquochuy.exercise03.Repository.ProductAttributeRepository;
import com.macquochuy.exercise03.service.ProductAttributeService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductAttributeServiceImpl implements ProductAttributeService {
    private ProductAttributeRepository productAttributeRepository;

    @Override
    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }

    @Override
    public ProductAttribute getProductAttributeById(UuidGenerator productAttributeId) {
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
    public void deleteProductAttribute(UuidGenerator productAttributeId) {
        productAttributeRepository.deleteById(productAttributeId);
    }
}
