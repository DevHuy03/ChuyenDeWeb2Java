package com.macquochuy.exercise03.Repository;

import org.hibernate.id.uuid.UuidGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise03.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, UuidGenerator> {
}
