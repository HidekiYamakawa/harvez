package com.hideki.harvez.dto;

import org.springframework.data.domain.Page;

import com.hideki.harvez.model.Employee;

import lombok.Getter;

@Getter
public class EmployeeNamesDTO {

	private Long id;
	private String name;

	public EmployeeNamesDTO(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
	}

	public static Page<EmployeeNamesDTO> converterToDTO(Page<Employee> employees) {
		return employees.map(EmployeeNamesDTO::new);
	}
	
}
