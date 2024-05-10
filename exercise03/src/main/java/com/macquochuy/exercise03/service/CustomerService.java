package com.macquochuy.exercise03.service;

import java.util.List;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;

import com.macquochuy.exercise03.entity.Customer;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer getCustomerById(UuidGenerator customerId);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer);
    
    void deleteCustomer(UuidGenerator customerId);
}