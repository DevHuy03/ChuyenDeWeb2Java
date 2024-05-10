package com.macquochuy.exercise02.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise02.Entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
