package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.Supplier;

public interface SupplyService {

    Supplier createSupply(Supplier supplier);

    Supplier getSupplyById(UUID supplierId);

    List<Supplier> getAllSupplys();

    Supplier updateSupply(Supplier supplier);
    
    void deleteSupply(UUID supplierId);
}