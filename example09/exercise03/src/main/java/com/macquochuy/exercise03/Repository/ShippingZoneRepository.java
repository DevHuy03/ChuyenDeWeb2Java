package com.macquochuy.exercise03.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise03.entity.ShippingZone;

@Repository
public interface ShippingZoneRepository extends JpaRepository<ShippingZone, Integer> {
}


