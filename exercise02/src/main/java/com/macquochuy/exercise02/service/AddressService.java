package com.macquochuy.exercise02.service;

import java.util.List;

import com.macquochuy.exercise02.Entity.Address;

public interface AddressService {
    Address createAddress(Address address);
    Address getAddressById(Long addressId);
    List<Address> getAllAddresses();
    Address updateAddress(Address address);
    void deleteAddress(Long addressId);
}

