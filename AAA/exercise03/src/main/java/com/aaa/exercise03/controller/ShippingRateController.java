package com.aaa.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aaa.exercise03.entity.ShippingRate;
import com.aaa.exercise03.service.ShippingRateService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/shippingRates")
public class ShippingRateController {

    private ShippingRateService shippingRateService;

    // Create ShippingRate REST API
    @PostMapping
    public ResponseEntity<ShippingRate> createShippingRate(@RequestBody ShippingRate shippingRate) {
        ShippingRate savedShippingRate = shippingRateService.createShippingRate(shippingRate);
        return new ResponseEntity<>(savedShippingRate, HttpStatus.CREATED);
    }

    // Get ShippingRate by id REST API
    // http://localhost:8080/api/shippingRates/{id}
    @GetMapping("{id}")
    public ResponseEntity<ShippingRate> getShippingRateById(@PathVariable("id") UUID shippingRateId) {
        ShippingRate shippingRate = shippingRateService.getShippingRateById(shippingRateId);
        return new ResponseEntity<>(shippingRate, HttpStatus.OK);
    }

    // Get All ShippingRates REST API
    // http://localhost:8080/api/shippingRates
    @GetMapping
    public ResponseEntity<List<ShippingRate>> getAllShippingRates() {
        List<ShippingRate> shippingRates = shippingRateService.getAllShippingRates();
        return new ResponseEntity<>(shippingRates, HttpStatus.OK);
    }

    // Update ShippingRate REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/shippingRates/{id}
    public ResponseEntity<ShippingRate> updateShippingRate(@PathVariable("id") UUID shippingRateId,
                                                            @RequestBody ShippingRate shippingRate) {
        shippingRate.setId(shippingRateId);
        ShippingRate updatedShippingRate = shippingRateService.updateShippingRate(shippingRate);
        if (updatedShippingRate != null) {
            return new ResponseEntity<>(updatedShippingRate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete ShippingRate REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShippingRate(@PathVariable("id") UUID shippingRateId) {
        shippingRateService.deleteShippingRate(shippingRateId);
        return new ResponseEntity<>("ShippingRate successfully deleted!", HttpStatus.OK);
    }
}
