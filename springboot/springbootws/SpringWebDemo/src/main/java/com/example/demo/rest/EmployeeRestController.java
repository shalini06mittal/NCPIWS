package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping()
	public List<Employee> getAllEmployees()
	{
		return this.employeeService.getEmployees();
	}
	@GetMapping(path="/id")
	public Employee getEmployeeById()
	{
		
		return this.employeeService.getEmployeeById(0);
	}
}


