package com.empolyemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empolyemanager.entities.Employee;

public interface employeeRepo extends JpaRepository<Employee, Long> {
	
}
