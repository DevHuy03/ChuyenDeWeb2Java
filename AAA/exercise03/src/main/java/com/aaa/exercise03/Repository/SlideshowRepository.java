package com.aaa.exercise03.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaa.exercise03.entity.Slideshow;

@Repository
public interface SlideshowRepository extends JpaRepository<Slideshow, UUID> {
}


