package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import com.macquochuy.exercise03.entity.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer getCustomerById(UUID customerId);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);
    
    void deleteCustomer(UUID customerId);
}