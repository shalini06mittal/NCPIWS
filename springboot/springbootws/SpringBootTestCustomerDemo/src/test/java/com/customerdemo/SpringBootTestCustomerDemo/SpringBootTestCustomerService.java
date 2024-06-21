package com.customerdemo.SpringBootTestCustomerDemo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.customerdemo.SpringBootTestCustomerDemo.beans.Customer;
import com.customerdemo.SpringBootTestCustomerDemo.database.CustomerRepository;
import com.customerdemo.SpringBootTestCustomerDemo.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestCustomerService {

	@Autowired
	private CustomerService service;
	Customer c1, c2;
	
	@Before
	public void setUp()
	{
		c1 = new Customer(1, "Kavita", "91919191919");
		c2 = new Customer(1, "Barbie", "88888888888");
	}
	
	@MockBean
	private CustomerRepository repository;
	
	@Test
	public void testGetCustomerByID()
	{
		when(repository.findById(c1.getCid())).thenReturn(Optional.of(c1));
		assertThat(service.getCustomer(1)).isEqualTo(c1);		
	}
	@Test
	public void testGetCustomers()
	{
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		when(repository.findAll()).thenReturn(customers);
		assertThat(service.getCustomers().size()).isEqualTo(2);		
	}
	@Test
	public void testInsertCustomer()
	{
		when(repository.save(c1)).thenReturn(c1);
		assertThat(service.insert(c1)).isTrue();		
	}
	@Test
	public void testUpdateCustomer()
	{
		c1.setCname("AAA");
		when(repository.save(c1)).thenReturn(c1);
		assertThat(service.update(c1)).isTrue();
		when(repository.findById(c1.getCid())).thenReturn(Optional.of(c1));
		assertThat(service.getCustomer(1).getCname()).isEqualTo("AAA");
		
	}
}








