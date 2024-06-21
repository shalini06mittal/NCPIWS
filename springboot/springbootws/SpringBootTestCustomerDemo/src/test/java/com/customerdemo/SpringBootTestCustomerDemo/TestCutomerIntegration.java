package com.customerdemo.SpringBootTestCustomerDemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.customerdemo.SpringBootTestCustomerDemo.beans.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
classes = SpringBootTestCustomerDemoApplication.class)
public class TestCutomerIntegration {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate template;
	private HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testCreateCustomer() throws JsonProcessingException
	{
		Customer c1 = new Customer(1, "Shalini", "324324234");
		String uri = "http://localhost:"+port+"/customers";
		String inputjson = mapToJson(c1);
		
//		HttpEntity<Customer> entity = new HttpEntity<Customer>(c1);
//		ResponseEntity<String> response = 
//				this.template.exchange(uri, HttpMethod.POST, entity, String.class);
		
		
		ResponseEntity<String> response =  this.template.postForEntity(uri, c1, String.class);
		
		String responsejson = response.getBody();
		assertThat(responsejson).isEqualTo("Inserted");
		
	}@Test
	public void testgetCustomerById() throws JsonProcessingException
	{
		Customer c1 = new Customer(1, "Shalini", "324324234");
		String uri = "http://localhost:"+port+"/customers";
		String inputjson = mapToJson(c1);
		
		HttpEntity<Customer> entity = new HttpEntity<Customer>(c1);
		this.template.exchange(uri, HttpMethod.POST, entity, String.class);
		
		uri = "http://localhost:"+port+"/customers/1";
		String response = this.template.getForObject(uri, String.class);
		
		assertThat(response).isEqualTo(inputjson);
		
	}
	/**
	 * this utility method Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
	 */
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}


}
