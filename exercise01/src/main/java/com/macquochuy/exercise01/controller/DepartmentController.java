package com.macquochuy.exercise01.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.macquochuy.exercise01.entity.Department;
import com.macquochuy.exercise01.service.DepartmentService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {
    private DepartmentService departmentService;
    
    // Create Department REST API
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.createDepartment(department); 
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    
    // Get Department by id REST API
    // http://localhost:8080/api/departments/1
    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) { 
        Department department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
    
    // Get All Departments REST API
    // http://localhost:8080/api/departments
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments(); 
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
    
    // Update Department REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/departments/1
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) { 
        department.setId(departmentId);
        Department updatedDepartment = departmentService.updateDepartment(department); 
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }
    
    // Delete Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId); 
        return new ResponseEntity<>("Department successfully deleted!", HttpStatus.OK);
    }
}