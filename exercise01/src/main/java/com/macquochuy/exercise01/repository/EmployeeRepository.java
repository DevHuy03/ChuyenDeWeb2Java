package com.macquochuy.exercise01.repository;
import org.springframework.data.jpa.repository. JpaRepository;
 import com.macquochuy.exercise01.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Long> { }

