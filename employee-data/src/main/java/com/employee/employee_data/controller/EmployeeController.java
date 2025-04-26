package com.employee.employee_data.controller;

import com.employee.employee_data.exception.ResourceNotFoundException;
import com.employee.employee_data.model.Employee;
import com.employee.employee_data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/api/v1/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/api/v1/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("/api/v1/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long employeeId){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+ employeeId));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/api/v1/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long employeeId,@RequestBody Employee employee){
        Employee updateEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+ employeeId));
        employee.setId(updateEmployee.getId());
        employeeRepository.save(employee);

        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/api/v1/employees/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable  long employeeId){
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: "+ employeeId));

        employeeRepository.delete(employee);

        return ResponseEntity.ok(employee);
    }
}
