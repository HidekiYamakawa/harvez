package com.hideki.harvez.controller;

import java.util.List;

import com.hideki.harvez.model.Employee;
import com.hideki.harvez.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping
    List<Employee> list() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    Employee findEmployeeById(@PathVariable Long id) {

        return employeeRepository.findById(id).orElse(null);
        // .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @GetMapping("/name")
    Employee findEmployeeByExactName(@RequestParam String fullName) {
        return employeeRepository.findFirstByName(fullName);
    }

    @GetMapping("/name/contains")
    List<Employee> findEmployeeByNameContaining(@RequestParam String pieceOfName) {
        return employeeRepository.findByNameContainingOrderByName(pieceOfName);
    }

    @PostMapping
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @PutMapping("/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

}
