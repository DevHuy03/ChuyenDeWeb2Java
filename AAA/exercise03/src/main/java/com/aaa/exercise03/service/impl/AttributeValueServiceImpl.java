package com.aaa.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.aaa.exercise03.Repository.AttributeValueRepository;
import com.aaa.exercise03.entity.AttributeValue;
import com.aaa.exercise03.service.AttributeValueService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AttributeValueServiceImpl implements AttributeValueService {
    private final AttributeValueRepository attributeValueRepository;

    @Override
    public AttributeValue createAttributeValue(AttributeValue attributeValue) {
        return attributeValueRepository.save(attributeValue);
    }

    @Override
    public AttributeValue getAttributeValueById(UUID attributeValueId) {

        Optional<AttributeValue> optionalAttributeValue = attributeValueRepository.findById(attributeValueId);
        return optionalAttributeValue.orElse(null);
    }

    @Override
    public List<AttributeValue> getAllAttributeValues() {
        return attributeValueRepository.findAll();
    }

    @Override
    public AttributeValue updateAttributeValue(AttributeValue attributeValue) {

        Optional<AttributeValue> optionalExistingAttributeValue = attributeValueRepository.findById(attributeValue.getId());
        if (optionalExistingAttributeValue.isPresent()) {
            AttributeValue existingAttributeValue = optionalExistingAttributeValue.get();
            existingAttributeValue.setAttribute_id(attributeValue.getAttribute_id());
            existingAttributeValue.setAttribute_value(attributeValue.getAttribute_value());
            existingAttributeValue.setColor(attributeValue.getColor());
            AttributeValue updatedAttributeValue = attributeValueRepository.save(existingAttributeValue);
            return updatedAttributeValue;
        }

        return null;
    }

    @Override
    public void deleteAttributeValue(UUID attributeValueId) {
        attributeValueRepository.deleteById(attributeValueId);
    }
}
