package com.aaa.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aaa.exercise03.entity.ShippingCountryZone;
import com.aaa.exercise03.service.ShippingCountryZoneService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/shipping-countries")
public class ShippingCountryZoneController {

    private ShippingCountryZoneService shippingCountryService;

    // Create ShippingCountryZone REST API
    @PostMapping
    public ResponseEntity<ShippingCountryZone> createShippingCountry(@RequestBody ShippingCountryZone shippingCountry) {
        ShippingCountryZone savedShippingCountry = shippingCountryService.createShippingCountry(shippingCountry);
        return new ResponseEntity<>(savedShippingCountry, HttpStatus.CREATED);
    }

    // Get ShippingCountryZone by id REST API
    // http://localhost:8080/api/shipping-countries/{id}
    @GetMapping("{id}")
    public ResponseEntity<ShippingCountryZone> getShippingCountryById(@PathVariable("id") UUID shippingCountryId) {
        ShippingCountryZone shippingCountry = shippingCountryService.getShippingCountryById(shippingCountryId);
        return new ResponseEntity<>(shippingCountry, HttpStatus.OK);
    }

    // Get All ShippingCountrys REST API
    // http://localhost:8080/api/shipping-countries
    @GetMapping
    public ResponseEntity<List<ShippingCountryZone>> getAllShippingCountrys() {
        List<ShippingCountryZone> shippingCountries = shippingCountryService.getAllShippingCountrys();
        return new ResponseEntity<>(shippingCountries, HttpStatus.OK);
    }

    // Update ShippingCountryZone REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/shipping-countries/{id}
    public ResponseEntity<ShippingCountryZone> updateShippingCountry(@PathVariable("id") UUID shippingCountryId,
                                            @RequestBody ShippingCountryZone shippingCountry) {
        shippingCountry.setId(shippingCountryId);
        ShippingCountryZone updatedShippingCountry = shippingCountryService.updateShippingCountry(shippingCountry);
        if (updatedShippingCountry != null) {
            return new ResponseEntity<>(updatedShippingCountry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete ShippingCountryZone REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShippingCountry(@PathVariable("id") UUID shippingCountryId) {
        shippingCountryService.deleteShippingCountry(shippingCountryId);
        return new ResponseEntity<>("ShippingCountryZone successfully deleted!", HttpStatus.OK);
    }
}
