package com.customerdemo.SpringBootTestCustomerDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.customerdemo.SpringBootTestCustomerDemo.beans.Customer;
import com.customerdemo.SpringBootTestCustomerDemo.resource.CustomerResource;
import com.customerdemo.SpringBootTestCustomerDemo.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerResource.class)
public class TestCustomerResource {
	
	@Autowired
	private MockMvc mock;
	
	@MockBean
	private CustomerService service;
	
	@Test
	public void testCreateCustomer() throws Exception
	{
		Customer c1 = new Customer(1, "BLAA", "99999999");
		when(service.insert(Mockito.any(Customer.class))).thenReturn(true);
		String uri= "/customers";
		String custjson = mapToJson(c1);
		
		RequestBuilder request = MockMvcRequestBuilders.post(uri).content(custjson)
		.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mock.perform(request).andReturn();
		
		MockHttpServletResponse response =  result.getResponse();
		
		String output = response.getContentAsString();
		
		assertThat(output).isEqualTo("Inserted");
		assertEquals(HttpStatus.OK.value(),response.getStatus());
	}
	
	Customer c1, c2, c3;
	@Before
	public void setup()
	{
		 c1 = new Customer(1, "BLAA", "99999999");
		 c2 = new Customer(2, "AAA", "3333333");
		 c3 = new Customer(3, "HHHH", "666666666");
	}
	
	@Test
	public void testGetAllCustomers() throws Exception
	{
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		when(service.getCustomers()).thenReturn(customers);
		String uri= "/customers";
		String expected = mapToJson(customers);
		
		RequestBuilder request = MockMvcRequestBuilders.get(uri)
		.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mock.perform(request).andReturn();
		
		MockHttpServletResponse response =  result.getResponse();
		
		String output = response.getContentAsString();
		
		assertThat(output).isEqualTo(expected);
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		
	}
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}


}










