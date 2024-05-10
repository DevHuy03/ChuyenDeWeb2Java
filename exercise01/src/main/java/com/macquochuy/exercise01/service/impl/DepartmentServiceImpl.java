package com.macquochuy.exercise01.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.macquochuy.exercise01.entity.Department;
import com.macquochuy.exercise01.service.DepartmentService;
import com.macquochuy.exercise01.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        return optionalDepartment.orElse(null);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department) {
        Department existingDepartment = departmentRepository.findById(department.getId()).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setName(department.getName());
            
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
