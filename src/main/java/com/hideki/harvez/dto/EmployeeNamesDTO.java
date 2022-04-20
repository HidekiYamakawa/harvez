package com.hideki.harvez.dto;

import java.util.List;
import java.util.stream.Collectors;

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

	public static List<EmployeeNamesDTO> converterToDTO(List<Employee> employees) {
		return employees.stream().map(EmployeeNamesDTO::new).collect(Collectors.toList());
	}
	
}
