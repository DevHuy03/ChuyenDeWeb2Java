package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.Attribute;

public interface AttributeService {

    Attribute createAttribute(Attribute attribute);

    Attribute getAttributeById(UUID attributeId);

    List<Attribute> getAllAttributes();

    Attribute updateAttribute(Attribute attribute);
    
    void deleteAttribute(UUID attributeId);
}