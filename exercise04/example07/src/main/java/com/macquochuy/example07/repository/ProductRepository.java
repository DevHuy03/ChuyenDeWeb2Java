package com.macquochuy.example07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.macquochuy.example07.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
