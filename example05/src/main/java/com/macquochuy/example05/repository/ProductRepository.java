package com.macquochuy.example05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.macquochuy.example05.entity.Product;
public interface ProductRepository extends JpaRepository<Product,Long>{
} 
