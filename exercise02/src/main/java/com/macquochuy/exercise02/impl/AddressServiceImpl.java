package com.macquochuy.exercise02.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.macquochuy.exercise02.Entity.Address;
import com.macquochuy.exercise02.Repository.AddressRepository;
import com.macquochuy.exercise02.service.AddressService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address createAddress(Address address) {
        address.setCreated_at(new Date());
        address.setUpdated_at(new Date());
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Long addressId) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        return optionalAddress.orElse(null);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address updateAddress(Address address) {
        Optional<Address> optionalExistingAddress = addressRepository.findById(address.getAddress_id());

        if (optionalExistingAddress.isPresent()) {
            Address existingAddress = optionalExistingAddress.get();
            existingAddress.setUser(address.getUser());
            existingAddress.setFull_address(address.getFull_address());
            existingAddress.setPostal_code(address.getPostal_code());
            existingAddress.setCity(address.getCity());
            existingAddress.setUpdated_at(new Date());

            return addressRepository.save(existingAddress);
        } else {
            // Trả về null nếu địa chỉ không tồn tại
            return null;
        }
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}

