package com.customerdemo.SpringBootTestCustomerDemo;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.customerdemo.SpringBootTestCustomerDemo.beans.Customer;
import com.customerdemo.SpringBootTestCustomerDemo.database.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringBootTestCustomerDatabase {

	Customer cust1, cust2;
	@Autowired
	private TestEntityManager manager;	 
	@Autowired
	private CustomerRepository repository;
	
	@Before
	public void setUp()
	{
		Customer c1 = new Customer(1, "Shalini", "121212121212");
		cust1 = manager.persist(c1);
		Customer c2 = new Customer(2, "Seema", "989898989898");
		cust2 = manager.persist(c2);
	}
	@Test
	public void testSavedCustomer() {
		Customer getcustfromDB = repository.findById(1).get();
		assertThat(getcustfromDB).isEqualTo(cust1);
	}
	@Test
	public void testAllCustomers()
	{
		Iterable<Customer> iter = repository.findAll();
		List<Customer> customers = new ArrayList<Customer>();
		for (Customer cust : iter)
		{
			customers.add(cust);
		}
		assertThat(customers.size()).isEqualTo(2);
	}
	@Test
	public void testupdateCustomer()
	{
//		Customer c = manager.find(Customer.class, 1);
//		System.out.println(c);
		cust1.setCname("Tia");
		Customer fromdb = manager.persist(cust1);
		assertThat(cust1.getCname()).isEqualTo(fromdb.getCname());
	}
	@Test
	public void testdeleteCustomer()
	{		
		manager.remove(cust1);
		Customer c = manager.find(Customer.class, cust1.getCid());
		assertThat(c).isNull();
	}
}








