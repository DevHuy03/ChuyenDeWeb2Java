package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.ProductTag;
import com.macquochuy.exercise03.Repository.ProductTagRepository;
import com.macquochuy.exercise03.service.ProductTagService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductTagServiceImpl implements ProductTagService {
    private ProductTagRepository productTagRepository;

    @Override
    public ProductTag createProductTag(ProductTag productTag) {
        return productTagRepository.save(productTag);
    }

    @Override
    public ProductTag getProductTagById(UuidGenerator productTagId) {
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
    public void deleteProductTag(UuidGenerator productTagId) {
        productTagRepository.deleteById(productTagId);
    }
}
