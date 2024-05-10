package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.VariantValue;
import com.macquochuy.exercise03.service.VariantValueService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/variantValues")
public class VariantValueController {

    private VariantValueService variantValueService;

    // Create VariantValue REST API
    @PostMapping
    public ResponseEntity<VariantValue> createVariantValue(@RequestBody VariantValue variantValue) {
        VariantValue savedVariantValue = variantValueService.createVariantValue(variantValue);
        return new ResponseEntity<>(savedVariantValue, HttpStatus.CREATED);
    }

    // Get VariantValue by id REST API
    // http://localhost:8080/api/variantValues/{id}
    @GetMapping("{id}")
    public ResponseEntity<VariantValue> getVariantValueById(@PathVariable("id") UUID variantValueId) {
        VariantValue variantValue = variantValueService.getVariantValueById(variantValueId);
        return new ResponseEntity<>(variantValue, HttpStatus.OK);
    }

    // Get All VariantValues REST API
    // http://localhost:8080/api/variantValues
    @GetMapping
    public ResponseEntity<List<VariantValue>> getAllVariantValues() {
        List<VariantValue> variantValues = variantValueService.getAllVariantValues();
        return new ResponseEntity<>(variantValues, HttpStatus.OK);
    }

    // Update VariantValue REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/variantValues/{id}
    public ResponseEntity<VariantValue> updateVariantValue(@PathVariable("id") UUID variantValueId,
                                                      @RequestBody VariantValue variantValue) {
        variantValue.setId(variantValueId);
        VariantValue updatedVariantValue = variantValueService.updateVariantValue(variantValue);
        if (updatedVariantValue != null) {
            return new ResponseEntity<>(updatedVariantValue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete VariantValue REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVariantValue(@PathVariable("id") UUID variantValueId) {
        variantValueService.deleteVariantValue(variantValueId);
        return new ResponseEntity<>("VariantValue successfully deleted!", HttpStatus.OK);
    }
}
