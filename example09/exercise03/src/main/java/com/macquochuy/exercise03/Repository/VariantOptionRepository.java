package com.macquochuy.exercise03.Repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise03.entity.VariantOption;

@Repository
public interface VariantOptionRepository extends JpaRepository<VariantOption, UUID> {
}


