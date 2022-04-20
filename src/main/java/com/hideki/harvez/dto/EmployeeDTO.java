package com.hideki.harvez.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.hideki.harvez.model.Employee;
import com.hideki.harvez.repository.EmployeeRepository;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmployeeDTO {

	private Long id;

	@NotNull @NotEmpty @Length(max = 124)
	private String name;
	
	private String office;

	public EmployeeDTO(Employee employee) {
		this.id = employee.getId();
		this.name = employee.getName();
		this.office = employee.getOffice();
	}

	public Employee converterToEntity() {
		return new Employee(name, office);
	}

	public Employee update(Long id, EmployeeRepository employeeRepository) {
		Employee employee = employeeRepository.getById(id);

		employee.setName(this.name);
		employee.setOffice(this.office);
		
		employeeRepository.flush();
		
		return employee;
	}

}
