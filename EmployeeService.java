package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.Employee;

public interface EmployeeService {


	public List<Employee> getEmployee();

	Employee saveEmployee(Employee employee);

	public Optional<Employee> getEmployeeById(Integer id);
	public Employee UpdateEmployee( int id,Employee employee);

	public void deleteEmployee(Integer id);

	public List<Employee> getListByCity(String city);
}
