package com.customerdemo.SpringBootTestCustomerDemo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerdemo.SpringBootTestCustomerDemo.beans.Customer;
import com.customerdemo.SpringBootTestCustomerDemo.database.CustomerRepository;



@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	public CustomerService() {
		System.out.println("Customer Service constructor");
	}	
	public long getCustomerCount()
	{
		return this.repository.count();
	}
	public String getCustomerName(int id) {
		
		String name = null;
		try {
			name = this.repository.findById(id).get().getCname();
		}catch(Exception e)
		{
			return name;
		}
		return name;
	}
	public List<Customer> getCustomers()
	{
		List<Customer> customers = new ArrayList<Customer>();
		this.repository.findAll().forEach((cust)->customers.add(cust));
		return customers;
	}
	public Customer getCustomer(int id)
	{
		System.out.println("id "+id);
		return this.repository.findById(id).get();
	}
	public boolean insert(Customer customer)
	{		
		try {
			this.repository.save(customer);
		}
		catch(Exception e)
		{
			return false;
		}	
		return true;
	}
	public boolean update(Customer customer)
	{
		try {
			this.repository.save(customer);
		}
		catch(Exception e)
		{
			return false;
		}	
		return true;
	}
	public boolean delete(int id)
	{
		try {
			this.repository.deleteById(id);
		}
		catch(Exception e)
		{
			return false;
		}	
		return true;
	}
	
	
}












