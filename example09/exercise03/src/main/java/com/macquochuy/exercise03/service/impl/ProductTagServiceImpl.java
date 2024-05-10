package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.Repository.ProductTagRepository;
import com.macquochuy.exercise03.entity.ProductTag;
import com.macquochuy.exercise03.service.ProductTagService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductTagServiceImpl implements ProductTagService {
    private ProductTagRepository productTagRepository;

    @Override
    public ProductTag createProductTag(ProductTag productTag) {
        return productTagRepository.save(productTag);
    }

    @Override
    public ProductTag getProductTagById(UUID productTagId) {
        Optional<ProductTag> optionalProductCategory = productTagRepository.findById(productTagId);
        return optionalProductCategory.orElse(null);
    }

    @Override
    public List<ProductTag> getAllProductTag() {
        return productTagRepository.findAll();
    }

    @Override
    public ProductTag updateProductTag(ProductTag productTag) {
        Optional<ProductTag> optionalExistingProductTag = productTagRepository.findById(productTag.getId());
        if (optionalExistingProductTag.isPresent()) {
            ProductTag existingProductTag = optionalExistingProductTag.get();
            existingProductTag.setProduct_id(productTag.getProduct_id());
            existingProductTag.setTag_id(productTag.getTag_id());

            ProductTag updatedProductTag = productTagRepository.save(existingProductTag);
            return updatedProductTag;
        }

        return null;
    }

    @Override
    public void deleteProductTag(UUID productTagId) {
        productTagRepository.deleteById(productTagId);
    }
}
