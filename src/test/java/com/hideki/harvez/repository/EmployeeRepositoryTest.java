package com.hideki.harvez.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.hideki.harvez.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class EmployeeRepositoryTest {

	@Autowired	
	private EmployeeRepository repository;
	
	@Test
	public void shouldLoadAnEmployeeByName() {
		String employeeName = "Carlos Hideki Yamakawa";
		Employee employee = repository.findFirstByName(employeeName);
		assertNotNull(employee);
		assertEquals(employeeName, employee.getName());
	}
	
	@Test
	public void shouldNotLoadAnEmployeeThatIsNotRegistered() {
		String employeeName = "fallen fer fnx";
		Employee employee = repository.findFirstByName(employeeName);
		assertNull(employee);
	}

}
