package com.macquochuy.exercise02.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise02.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

