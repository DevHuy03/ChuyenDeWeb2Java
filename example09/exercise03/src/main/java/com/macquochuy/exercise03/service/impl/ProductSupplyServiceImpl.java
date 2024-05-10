package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.ProductSupplier;
import com.macquochuy.exercise03.Repository.ProductSupplierRepository;
import com.macquochuy.exercise03.service.ProductSupplyService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductSupplyServiceImpl implements ProductSupplyService {
    private ProductSupplierRepository productSupplyRepository;

    @Override
    public ProductSupplier createProductSupply(ProductSupplier productSupply) {
        return productSupplyRepository.save(productSupply);
    }

    @Override
    public ProductSupplier getProductSupplyById(UUID productId) {
        Optional<ProductSupplier> optionalProductSupply = productSupplyRepository.findById(productId);
        return optionalProductSupply.orElse(null);
    }

    @Override
    public List<ProductSupplier> getAllProductSupplys() {
        return productSupplyRepository.findAll();
    }

    @Override
    public ProductSupplier updateProductSupply(ProductSupplier productSupply) {
        Optional<ProductSupplier> optionalExistingProductSupply = productSupplyRepository.findById(productSupply.getId());
        if (optionalExistingProductSupply.isPresent()) {
            ProductSupplier existingProductSupply = optionalExistingProductSupply.get();
            existingProductSupply.setProduct_id(productSupply.getProduct_id());
            existingProductSupply.setSupplier_id(productSupply.getSupplier_id());
            

            ProductSupplier updatedProductSupply = productSupplyRepository.save(existingProductSupply);
            return updatedProductSupply;
        }

        return null;
    }

    @Override
    public void deleteProductSupply(UUID productId) {
        productSupplyRepository.deleteById(productId);
    }
}
