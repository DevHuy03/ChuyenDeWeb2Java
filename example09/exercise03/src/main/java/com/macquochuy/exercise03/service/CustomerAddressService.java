package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;
import com.macquochuy.exercise03.entity.CustomerAddress;

public interface CustomerAddressService {

    CustomerAddress createCustomerAddress(CustomerAddress customerAddress);

    CustomerAddress getCustomerAddressById(UUID customerAddressId);

    List<CustomerAddress> getAllCustomerAddresses();

    CustomerAddress updateCustomerAddress(CustomerAddress customerAddress);
    
    void deleteCustomerAddress(UUID customerAddressId);
}