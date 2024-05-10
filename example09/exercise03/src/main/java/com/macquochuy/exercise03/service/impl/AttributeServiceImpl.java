package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Attribute;
import com.macquochuy.exercise03.Repository.AttributeRepository;
import com.macquochuy.exercise03.service.AttributeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor 
public class AttributeServiceImpl implements AttributeService {
    private final AttributeRepository attributeRepository;

    @Override
    public Attribute createAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @Override
    public Attribute getAttributeById(UUID attributeId) {

        Optional<Attribute> optionalAttribute = attributeRepository.findById(attributeId);
        return optionalAttribute.orElse(null);
    }

    @Override
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    @Override
    public Attribute updateAttribute(Attribute attribute) {

        Optional<Attribute> optionalExistingAttribute = attributeRepository.findById(attribute.getId());
        if (optionalExistingAttribute.isPresent()) {
            Attribute existingAttribute = optionalExistingAttribute.get();
            existingAttribute.setAttribute_name(attribute.getAttribute_name());
            existingAttribute.setUpdated_by(attribute.getUpdated_by());    
            Attribute updatedAttribute = attributeRepository.save(existingAttribute);
            return updatedAttribute;
        }
    
        return null; // Hoặc xử lý theo yêu cầu của bạn khi không tìm thấy thuộc tính tồn tại
    }
    

    @Override
    public void deleteAttribute(UUID attributeId) {
        attributeRepository.deleteById(attributeId);
    }
}
