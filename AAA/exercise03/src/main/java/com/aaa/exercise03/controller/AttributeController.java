package com.aaa.exercise03.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aaa.exercise03.entity.Attribute;
import com.aaa.exercise03.service.AttributeService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/attributes")
public class AttributeController {

    private AttributeService attributeService;

    // Create Attribute REST API
    @PostMapping
    public ResponseEntity<Attribute> createAttribute(@RequestBody Attribute attribute) {
        Attribute savedAttribute = attributeService.createAttribute(attribute);
        return new ResponseEntity<>(savedAttribute, HttpStatus.CREATED);
    }

    // Get Attribute by id REST API
    // http://localhost:8080/api/attributes/{id}
    @GetMapping("{id}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable("id") UUID attributeId) {
        Attribute attribute = attributeService.getAttributeById(attributeId);
        return new ResponseEntity<>(attribute, HttpStatus.OK);
    }

    // Get All Attributes REST API
    // http://localhost:8080/api/attributes
    @GetMapping
    public ResponseEntity<List<Attribute>> getAllAttributes() {
        List<Attribute> attributes = attributeService.getAllAttributes();
        return new ResponseEntity<>(attributes, HttpStatus.OK);
    }

    // Update Attribute REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/attributes/{id}
    public ResponseEntity<Attribute> updateAttribute(@PathVariable("id") UUID attributeId,
                                                      @RequestBody Attribute attribute) {
        attribute.setId(attributeId);
        Attribute updatedAttribute = attributeService.updateAttribute(attribute);
        if (updatedAttribute != null) {
            return new ResponseEntity<>(updatedAttribute, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Attribute REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAttribute(@PathVariable("id") UUID attributeId) {
        attributeService.deleteAttribute(attributeId);
        return new ResponseEntity<>("Attribute successfully deleted!", HttpStatus.OK);
    }
}
