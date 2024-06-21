package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpringWebDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(SpringWebDemoApplication.class, args);
		context.getBean(EmployeeService.class).getFilteredEmployees(1, 10);
	}
	@Autowired
	private EmployeeService employeeService;

	@PostConstruct
	public void initialize()
	{		
		for(int i=1;i<=100;i++) {
			Employee emp = new Employee();
			emp.setEname("Sia"+i);
			emp.setEmail("sia"+i+"@test.com");
			emp.setPassword("sia"+i);
			emp.setPhone("phone"+i);

			Employee e = employeeService.insertEmployee(emp);
		}
		//			Employee em = new Employee();
		//			em.setEname("John");
		//			em.setEmail("john@test.com");
		//			em.setPassword("john1235");
		//			em.setPhone("7654323456");
		//
		//			Employee e1 = employeeService.insertEmployee(em);

	}


}
