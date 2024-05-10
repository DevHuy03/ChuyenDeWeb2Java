package com.macquochuy.exercise03.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise03.entity.ShippingZone;
import com.macquochuy.exercise03.service.ShippingZoneService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/shippings")
public class ShippingControllerZone {

    private ShippingZoneService shippingService;

    // Create ShippingZone REST API
    @PostMapping
    public ResponseEntity<ShippingZone> createShipping(@RequestBody ShippingZone shipping) {
        ShippingZone savedShipping = shippingService.createShipping(shipping);
        return new ResponseEntity<>(savedShipping, HttpStatus.CREATED);
    }

    // Get ShippingZone by id REST API
    // http://localhost:8080/api/shippings/{id}
    @GetMapping("{id}")
    public ResponseEntity<ShippingZone> getShippingById(@PathVariable("id") Integer shippingId) {
        ShippingZone shipping = shippingService.getShippingById(shippingId);
        return new ResponseEntity<>(shipping, HttpStatus.OK);
    }

    // Get All Shippings REST API
    // http://localhost:8080/api/shippings
    @GetMapping
    public ResponseEntity<List<ShippingZone>> getAllShippings() {
        List<ShippingZone> shippings = shippingService.getAllShippings();
        return new ResponseEntity<>(shippings, HttpStatus.OK);
    }

    // Update ShippingZone REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/shippings/{id}
    public ResponseEntity<ShippingZone> updateShipping(@PathVariable("id") Integer shippingId,
                                                    @RequestBody ShippingZone shipping) {
        shipping.setId(shippingId);
        ShippingZone updatedShipping = shippingService.updateShipping(shipping);
        if (updatedShipping != null) {
            return new ResponseEntity<>(updatedShipping, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete ShippingZone REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShipping(@PathVariable("id") Integer shippingId) {
        shippingService.deleteShipping(shippingId);
        return new ResponseEntity<>("ShippingZone successfully deleted!", HttpStatus.OK);
    }
}
