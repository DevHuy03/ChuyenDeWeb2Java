package com.macquochuy.exercise03.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macquochuy.exercise03.entity.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, UUID> {
    // You can add custom query methods if needed
}