package com.macquochuy.exercise03.service;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Supplier;

public interface SupplyService {

    Supplier createSupply(Supplier supplier);

    Supplier getSupplyById(UuidGenerator supplierId);

    List<Supplier> getAllSupplys();

    Supplier updateSupply(Supplier supplier);
    
    void deleteSupply(UuidGenerator supplierId);
}