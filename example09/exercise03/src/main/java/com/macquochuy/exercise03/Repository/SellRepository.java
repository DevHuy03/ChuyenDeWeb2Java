package com.macquochuy.exercise03.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise03.entity.Sell;

@Repository
public interface SellRepository extends JpaRepository<Sell, Integer> {
}


