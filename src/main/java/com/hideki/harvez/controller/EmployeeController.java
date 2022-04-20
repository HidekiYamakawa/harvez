package com.hideki.harvez.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hideki.harvez.dto.EmployeeDTO;
import com.hideki.harvez.dto.EmployeeDetailsDTO;
import com.hideki.harvez.dto.EmployeeNamesDTO;
import com.hideki.harvez.model.Employee;
import com.hideki.harvez.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping
    List<EmployeeNamesDTO> list(String pieceOfName) {
    	System.out.println("pieceOfName: " + pieceOfName);
    	List<Employee> employees = new ArrayList<Employee>();
    	if (pieceOfName == null) {    		
    		employees = employeeRepository.findAll();    		
    		return EmployeeNamesDTO.converterToDTO(employees);
    	} else {
    		employees = employeeRepository.findByNameContainingOrderByName(pieceOfName);
    		return EmployeeNamesDTO.converterToDTO(employees);
    	}
    	
    }

    @GetMapping("/{id}")
    ResponseEntity<EmployeeDetailsDTO> detail(@PathVariable Long id) {
    	Optional<Employee> employeeData = employeeRepository.findById(id);
    	if (employeeData.isPresent()) {
    		return ResponseEntity.ok(new EmployeeDetailsDTO(employeeData.get()));    		
    	}
    	
    	return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    ResponseEntity<EmployeeDTO> create(@RequestBody @Valid EmployeeDTO newEmployee, UriComponentsBuilder uriBuilder) {
    	Employee employee = newEmployee.converterToEntity();
        employeeRepository.save(employee);
        
        URI uri = uriBuilder.path("/api/employees/{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeDTO(employee));
    }

    @PutMapping("/{id}")
    @Transactional
    ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @RequestBody @Valid EmployeeDTO employeeDto) {
    	Optional<Employee> employeeData = employeeRepository.findById(id);
    	if(employeeData.isPresent()) {
    		Employee employee = employeeDto.update(id, employeeRepository);
    		return ResponseEntity.ok(new EmployeeDTO(employee));    		
    	}
    	
    	return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    ResponseEntity<?> delete(@PathVariable Long id) {
    	Optional<Employee> employee = employeeRepository.findById(id);
    	if (employee.isPresent()) {
    		employeeRepository.deleteById(id);
    		return ResponseEntity.ok().build();
    	}
    	
        return ResponseEntity.notFound().build();
    }

}
