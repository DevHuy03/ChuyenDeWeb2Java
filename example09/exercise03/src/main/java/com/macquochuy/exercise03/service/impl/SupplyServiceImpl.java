package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Supplier;
import com.macquochuy.exercise03.Repository.SupplierRepository;
import com.macquochuy.exercise03.service.SupplyService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SupplyServiceImpl implements SupplyService {
    private SupplierRepository supplyRepository;

    @Override
    public Supplier createSupply(Supplier supply) {
        return supplyRepository.save(supply);
    }

    @Override
    public Supplier getSupplyById(UUID supplyId) {
        Optional<Supplier> optionalSupply = supplyRepository.findById(supplyId);
        return optionalSupply.orElse(null);
    }

    @Override
    public List<Supplier> getAllSupplys() {
        return supplyRepository.findAll();
    }

    @Override
    public Supplier updateSupply(Supplier supply) {
        Optional<Supplier> optionalExistingSupply = supplyRepository.findById(supply.getId());
        if (optionalExistingSupply.isPresent()) {
            Supplier existingSupply = optionalExistingSupply.get();
            existingSupply.setSupplier_name(supply.getSupplier_name());
            existingSupply.setCompany(supply.getCompany());
            existingSupply.setPhone_number(supply.getPhone_number());
            existingSupply.setAddress_line1(supply.getAddress_line1());
            existingSupply.setAddress_line2(supply.getAddress_line2());
            existingSupply.setCountry_id(supply.getCountry_id());
            existingSupply.setCity(supply.getCity());
            existingSupply.setNote(supply.getNote());
            existingSupply.setUpdated_at(new Date());
            existingSupply.setUpdated_by(supply.getUpdated_by());
            // Update fields accordingly based on your Supplier entity

            Supplier updatedSupply = supplyRepository.save(existingSupply);
            return updatedSupply;
        }

        return null;
    }

    @Override
    public void deleteSupply(UUID supplyId) {
        supplyRepository.deleteById(supplyId);
    }
}
