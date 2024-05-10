package com.macquochuy.exercise01.service;
import java.util.List;
import com.macquochuy.exercise01.entity.Employee;
public interface EmployeeService { 
  Employee createEmployee(Employee employee); 
    Employee getEmployeeById(Long employeeId);
     List<Employee> getAllEmployees();
     Employee updateEmployee (Employee employee);
       void deleteEmployee (Long employeeId);
}