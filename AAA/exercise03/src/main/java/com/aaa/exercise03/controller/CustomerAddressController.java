package com.aaa.exercise03.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aaa.exercise03.entity.CustomerAddress;
import com.aaa.exercise03.service.CustomerAddressService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/customerAddresses")
public class CustomerAddressController {

    private CustomerAddressService customerAddressService;

    // Create CustomerAddress REST API
    @PostMapping
    public ResponseEntity<CustomerAddress> createCustomerAddress(@RequestBody CustomerAddress customerAddress) {
        CustomerAddress savedCustomerAddress = customerAddressService.createCustomerAddress(customerAddress);
        return new ResponseEntity<>(savedCustomerAddress, HttpStatus.CREATED);
    }

    // Get CustomerAddress by id REST API
    // http://localhost:8080/api/customerAddresses/{id}
    @GetMapping("{id}")
    public ResponseEntity<CustomerAddress> getCustomerAddressById(@PathVariable("id") UUID customerAddressId) {
        CustomerAddress customerAddress = customerAddressService.getCustomerAddressById(customerAddressId);
        return new ResponseEntity<>(customerAddress, HttpStatus.OK);
    }

    // Get All CustomerAddresses REST API
    // http://localhost:8080/api/customerAddresses
    @GetMapping
    public ResponseEntity<List<CustomerAddress>> getAllCustomerAddresses() {
        List<CustomerAddress> customerAddresses = customerAddressService.getAllCustomerAddresses();
        return new ResponseEntity<>(customerAddresses, HttpStatus.OK);
    }

    // Update CustomerAddress REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/customerAddresses/{id}
    public ResponseEntity<CustomerAddress> updateCustomerAddress(@PathVariable("id") UUID customerAddressId,
                                                                  @RequestBody CustomerAddress customerAddress) {
        customerAddress.setId(customerAddressId);
        CustomerAddress updatedCustomerAddress = customerAddressService.updateCustomerAddress(customerAddress);
        if (updatedCustomerAddress != null) {
            return new ResponseEntity<>(updatedCustomerAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete CustomerAddress REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomerAddress(@PathVariable("id") UUID customerAddressId) {
        customerAddressService.deleteCustomerAddress(customerAddressId);
        return new ResponseEntity<>("Customer Address successfully deleted!", HttpStatus.OK);
    }
}
