package com.macquochuy.exercise01.repository;
import org.springframework.data.jpa.repository. JpaRepository;
 import com.macquochuy.exercise01.entity.Department;
public interface DepartmentRepository extends JpaRepository<Department, Long> { }