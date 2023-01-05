package com.empolyemanager;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.empolyemanager.entities.Employee;
import com.empolyemanager.service.employeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
@Bean
CommandLineRunner commandLineRunner(employeeService employeeService) {
	return args ->{
		Stream.of("Mike","Oscar","Julien").forEach(name->{
			Employee employee = new Employee();
			employee.setEmail(name + "@gmail.com");
			employee.setName(name);
			employee.setJobTitle("Developpeur");
			employee.setEmployeCode(UUID.randomUUID().toString());
			employee.setImageUrl("vvrrbrbr");
			employee.setPhone("0654785632");
			employeeService.addEmployee(employee);
		});
	};
}

}
