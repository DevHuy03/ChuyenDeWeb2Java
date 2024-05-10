package com.macquochuy.exercise01.service;
import java.util.List;
import com.macquochuy.exercise01.entity.Department;
public interface DepartmentService { 
    Department createDepartment (Department department); 
    Department getDepartmentById(Long departmentId);
     List<Department> getAllDepartments();
     Department updateDepartment (Department department);
       void deleteDepartment (Long departmentId);
}