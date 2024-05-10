package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.AttributeValue;

public interface AttributeValueService {

    AttributeValue createAttributeValue(AttributeValue attributeValue);

    AttributeValue getAttributeValueById(UUID attributeValueId);

    List<AttributeValue> getAllAttributeValues();

    AttributeValue updateAttributeValue(AttributeValue attributeValue);
    
    void deleteAttributeValue(UUID attributeValueId);
}