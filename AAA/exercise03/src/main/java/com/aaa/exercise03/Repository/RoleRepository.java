package com.aaa.exercise03.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaa.exercise03.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}


