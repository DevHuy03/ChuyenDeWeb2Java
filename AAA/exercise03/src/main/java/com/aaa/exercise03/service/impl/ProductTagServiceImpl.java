package com.aaa.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.aaa.exercise03.Repository.ProductTagRepository;
import com.aaa.exercise03.entity.ProductTag;
import com.aaa.exercise03.service.ProductTagService;

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
        Optional<ProductTag> optionalProductTag = productTagRepository.findById(productTagId);
        return optionalProductTag.orElse(null);
    }

    @Override
    public List<ProductTag> getAllProductTags() {
        return productTagRepository.findAll();
    }

    @Override
    public ProductTag updateProductTag(ProductTag productTag) {
        Optional<ProductTag> optionalExistingProductTag = productTagRepository.findById(productTag.getId());
        if (optionalExistingProductTag.isPresent()) {
            ProductTag existingProductTag = optionalExistingProductTag.get();
            existingProductTag.setTag_id(productTag.getTag_id()); // Sửa dòng này để cập nhật thẻ của ProductTag
            existingProductTag.setProduct_id(productTag.getProduct_id()); // Sửa dòng này để cập nhật sản phẩm của ProductTag

            ProductTag updatedProductTag = productTagRepository.save(existingProductTag);
            return updatedProductTag;
        }

        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy ProductTag tồn tại
    }

    @Override
    public void deleteProductTag(UUID productTagId) {
        productTagRepository.deleteById(productTagId);
    }
}
