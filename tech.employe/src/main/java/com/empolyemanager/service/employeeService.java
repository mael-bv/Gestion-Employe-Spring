package com.empolyemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empolyemanager.entities.Employee;
import com.empolyemanager.exception.UserNotFoundException;
import com.empolyemanager.repository.employeeRepo;
@Service
public class employeeService {
	
	@Autowired
	private employeeRepo employeeRepo;
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	
	public List<Employee> findAllEmployee(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmploye(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public void deleteEmploye(Long id) {
		 employeeRepo.deleteById(id);
	}
	
	public Employee findEmployeByid(Long id) {
		Employee e1 = employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user by id :" + id + " not found"));
		return e1;
	}

}
