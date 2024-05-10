package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Attribute;

public interface AttributeService {

    Attribute createAttribute(Attribute attribute);

    Attribute getAttributeById(UuidGenerator attributeId);

    List<Attribute> getAllAttributes();

    Attribute updateAttribute(Attribute attribute);
    
    void deleteAttribute(UuidGenerator attributeId);
}