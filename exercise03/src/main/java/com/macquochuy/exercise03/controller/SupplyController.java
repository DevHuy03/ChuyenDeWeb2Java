package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.Supplier;
import com.macquochuy.exercise03.service.SupplyService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/supplies")
public class SupplyController {

    private SupplyService supplyService;

    // Create Supplier REST API
    @PostMapping
    public ResponseEntity<Supplier> createSupply(@RequestBody Supplier supply) {
        Supplier savedSupply = supplyService.createSupply(supply);
        return new ResponseEntity<>(savedSupply, HttpStatus.CREATED);
    }

    // Get Supplier by id REST API
    // http://localhost:8080/api/supplies/{id}
    @GetMapping("{id}")
    public ResponseEntity<Supplier> getSupplyById(@PathVariable("id") UuidGenerator supplyId) {
        Supplier supply = supplyService.getSupplyById(supplyId);
        return new ResponseEntity<>(supply, HttpStatus.OK);
    }

    // Get All Supplies REST API
    // http://localhost:8080/api/supplies
    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSupplies() {
        List<Supplier> supplies = supplyService.getAllSupplys();
        return new ResponseEntity<>(supplies, HttpStatus.OK);
    }

    // Update Supplier REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/supplies/{id}
    public ResponseEntity<Supplier> updateSupply(@PathVariable("id") UuidGenerator supplyId,
                                            @RequestBody Supplier supply) {
        supply.setId(supplyId);
        Supplier updatedSupply = supplyService.updateSupply(supply);
        if (updatedSupply != null) {
            return new ResponseEntity<>(updatedSupply, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Supplier REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSupply(@PathVariable("id") UuidGenerator supplyId) {
        supplyService.deleteSupply(supplyId);
        return new ResponseEntity<>("Supplier successfully deleted!", HttpStatus.OK);
    }
}
