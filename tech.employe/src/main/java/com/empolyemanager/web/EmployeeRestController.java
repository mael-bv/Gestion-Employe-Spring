package com.empolyemanager.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empolyemanager.entities.Employee;
import com.empolyemanager.service.employeeService;

@RestController
@CrossOrigin("*")
public class EmployeeRestController {
	
	@Autowired
	private employeeService employeeService;
	
	@GetMapping("/fullEmployees")
	public List<Employee> getAllEmployee(){
		return employeeService.findAllEmployee();
	}
	
	@GetMapping("/find/{id}")
	public Employee getEmployeeByid(@PathVariable Long id) {
		return employeeService.findEmployeByid(id);
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		//employee.setEmployeCode(UUID.randomUUID().toString());
		return employeeService.updateEmploye(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee( @PathVariable Long id) {
		employeeService.deleteEmploye(id);
	}
}
