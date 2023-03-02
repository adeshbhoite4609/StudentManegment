package com.example.controller;



import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	org.apache.logging.log4j.Logger logger= LogManager.getLogger(EmployeeController.class);

@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		logger.info("inside save employee");
		Employee emp = employeeService.saveEmployee(employee);
		logger.info("inside save employee");
		return ResponseEntity.ok().body(emp);
	}
@GetMapping("/get")
public List<Employee> getEmployeeBy() {
	List<Employee> employee = employeeService.getEmployee();
	return employeeService.getEmployee();
}

@PutMapping("/update/{id}")
public Employee UpdateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
	logger.info("inside save employee");
	return employeeService.UpdateEmployee(id, employee);
}
@DeleteMapping("/delete/{id}")
public void deleteEmployeeById(@PathVariable("id") Integer id) throws Exception {
	employeeService.deleteEmployee(id);
}

	@GetMapping("/getcity/{city}")
	public ResponseEntity<List<Employee>> getEmployeeByCity(@PathVariable("city") String city) {
		List<Employee> employee = employeeService.getListByCity(city);
		return ResponseEntity.ok().body(employee);
	}




	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		
		logger.debug("requestid:{}",id);
	Optional<Employee>employee = employeeService.getEmployeeById(id);
		if( employee.isPresent()){
			
			return new ResponseEntity<>( employee.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}	
}
}