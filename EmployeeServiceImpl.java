package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
	
		return employeeRepository.findById(id);
	}

	@Override
	public Employee UpdateEmployee(int id, Employee NewEntity) {
		Employee avilabelentity=employeeRepository.findById(id).get();
		if(avilabelentity!=null) {
			if(NewEntity!=null) {
				avilabelentity.setName(NewEntity.getName());
				
			}
			employeeRepository.save(avilabelentity);
		}
		return avilabelentity;
	}

	@Override
	public void deleteEmployee(Integer id) {
	
			employeeRepository.deleteById(id);


		
	}

	@Override
	public List<Employee> getListByCity(String city) {
		List<Employee> employee = employeeRepository.findByCity(city);
		return employee;


	
	}


	}

