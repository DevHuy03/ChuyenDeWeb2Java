package com.macquochuy.exercise03.Repository;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise03.entity.ProductAttributeValue;

@Repository
public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValue, UuidGenerator> {
}

