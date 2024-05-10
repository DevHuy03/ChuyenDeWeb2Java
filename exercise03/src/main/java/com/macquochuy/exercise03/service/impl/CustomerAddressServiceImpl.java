package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.CustomerAddress;
import com.macquochuy.exercise03.Repository.CustomerAddressRepository;
import com.macquochuy.exercise03.service.CustomerAddressService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerAddressServiceImpl implements CustomerAddressService {
    private CustomerAddressRepository customerAddressRepository;

    @Override
    public CustomerAddress createCustomerAddress(CustomerAddress customerAddress) {
        return customerAddressRepository.save(customerAddress);
    }

    @Override
    public CustomerAddress getCustomerAddressById(UuidGenerator customerAddressId) {
        Optional<CustomerAddress> optionalCustomerAddress = customerAddressRepository.findById(customerAddressId);
        return optionalCustomerAddress.orElse(null);
    }

    @Override
    public List<CustomerAddress> getAllCustomerAddresses() {
        return customerAddressRepository.findAll();
    }

    @Override
    public CustomerAddress updateCustomerAddress(CustomerAddress customerAddress) {
        Optional<CustomerAddress> optionalExistingCustomerAddress = customerAddressRepository.findById(customerAddress.getId());
        if (optionalExistingCustomerAddress.isPresent()) {
            CustomerAddress existingCustomerAddress = optionalExistingCustomerAddress.get();
            existingCustomerAddress.setCustomer_id(customerAddress.getCustomer_id());
            existingCustomerAddress.setAddress_line1(customerAddress.getAddress_line1());
            existingCustomerAddress.setAddress_line2(customerAddress.getAddress_line2());
            existingCustomerAddress.setPhone_number(customerAddress.getPhone_number());
            existingCustomerAddress.setDial_code(customerAddress.getDial_code());
            existingCustomerAddress.setCountry(customerAddress.getCountry());
            existingCustomerAddress.setPostal_code(customerAddress.getPostal_code());
            existingCustomerAddress.setCity(customerAddress.getCity());
            CustomerAddress updatedCustomerAddress = customerAddressRepository.save(existingCustomerAddress);
            return updatedCustomerAddress;
        }

        return null;
    }

    @Override
    public void deleteCustomerAddress(UuidGenerator customerAddressId) {
        customerAddressRepository.deleteById(customerAddressId);
    }
}
