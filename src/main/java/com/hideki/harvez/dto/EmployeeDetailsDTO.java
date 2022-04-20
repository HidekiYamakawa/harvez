package com.hideki.harvez.dto;

import com.hideki.harvez.model.Employee;

import lombok.Getter;

@Getter
public class EmployeeDetailsDTO {

	private Long id;
	private String name;
	private String office;
	
	public EmployeeDetailsDTO(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.office = employee.getOffice();
	}
}
