package com.macquochuy.exercise02.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macquochuy.exercise02.Entity.Like;
import com.macquochuy.exercise02.Entity.LikeId;

@Repository
public interface LikeRepository extends JpaRepository<Like, LikeId> {
}
