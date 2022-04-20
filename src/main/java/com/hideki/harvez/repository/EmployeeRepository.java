package com.hideki.harvez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hideki.harvez.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findFirstByName(String name);

    List<Employee> findByNameContainingOrderByName(String name);
}
