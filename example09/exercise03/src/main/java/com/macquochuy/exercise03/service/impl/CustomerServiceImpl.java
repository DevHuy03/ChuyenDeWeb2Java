package com.macquochuy.exercise03.service.impl;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.macquochuy.exercise03.entity.Customer;
import com.macquochuy.exercise03.Repository.CustomerRepository;
import com.macquochuy.exercise03.service.CustomerService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        return optionalCustomer.orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> optionalExistingCustomer = customerRepository.findById(customer.getId());
        if (optionalExistingCustomer.isPresent()) {
            Customer existingCustomer = optionalExistingCustomer.get();
            existingCustomer.setFirst_name(customer.getFirst_name());
            existingCustomer.setLast_name(customer.getLast_name());
            existingCustomer.setPhone_number(customer.getPhone_number());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPassword_hash(customer.getPassword_hash());
            existingCustomer.setActive(customer.isActive());
            existingCustomer.setResgister_at(new Date());
            existingCustomer.setUpdated_at(new Date());
            Customer updatedCustomer = customerRepository.save(existingCustomer);
            return updatedCustomer;
        }

        return null;
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        customerRepository.deleteById(customerId);
    }
}
