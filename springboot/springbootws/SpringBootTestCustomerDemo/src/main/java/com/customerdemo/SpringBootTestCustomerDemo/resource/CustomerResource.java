package com.customerdemo.SpringBootTestCustomerDemo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerdemo.SpringBootTestCustomerDemo.beans.Customer;
import com.customerdemo.SpringBootTestCustomerDemo.service.CustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerResource {

	@Autowired
	CustomerService service;	
	@GetMapping(path = "/{id}",produces = {"application/xml","application/json"})
	public Customer getCustomerById(@PathVariable int id)
	{
		return this.service.getCustomer(id);
	}
	@GetMapping(produces = {"application/xml","application/json"})
	public List<Customer> getAllCustomers()
	{
		return this.service.getCustomers();
	}
	@PostMapping(consumes = {"application/xml","application/json"})
	public String insertCustomer(@RequestBody Customer customer)
	{
		if(this.service.insert(customer))
			return "Inserted";
		return "failed insertion";
	}
	@PutMapping
	public String updateCustomer(@RequestBody Customer customer)
	{
		if(this.service.update(customer))
			return "Updated";
		return "Failed updation";
	}
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		if(this.service.delete(id))
			return "deleted";
		return "Failed deletion";
	}
}
