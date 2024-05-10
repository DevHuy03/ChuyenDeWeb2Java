package com.macquochuy.exercise02.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.exercise02.Entity.Address;
import com.macquochuy.exercise02.service.AddressService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/addresses")
public class AddressController {
    private final AddressService addressService;
    // Create Address REST API
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address savedAddress = addressService.createAddress(address);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    // Get Address by id REST API
    // http://localhost:8080/api/addresses/1
    @GetMapping("{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Long addressId) {
        Address address = addressService.getAddressById(addressId);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    // Get All Addresses REST API
    // http://localhost:8080/api/addresses
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    // Update Address REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/addresses/1
    public ResponseEntity<Address> updateAddress(@PathVariable("id") Long addressId,
                                                  @RequestBody Address address) {
        address.setAddress_id(addressId); // Thiết lập id cho địa chỉ cập nhật
        Address updatedAddress = addressService.updateAddress(address);
        if (updatedAddress != null) {
            return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Address REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long addressId) {
        addressService.deleteAddress(addressId);
        return new ResponseEntity<>("Address successfully deleted!", HttpStatus.OK);
    }
}
