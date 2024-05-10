package com.macquochuy.exercise03.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise03.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
