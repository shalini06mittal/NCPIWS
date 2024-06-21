package com.test.SpringBootTestDemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

// this instantialtes the spring runner to run spring applications
//@RunWith(SpringRunner.class)
// this created the web spring environment without starting the actual server
//@WebMvcTest(HomeController.class)
@AutoConfigureMockMvc
@SpringBootTest
public class WebMockMvcTest {
	// injects mock object to write test cases for mvc applicatins
    @Autowired
    private MockMvc mockMvc;
    // since controller has a dependency on service layer, this injects
    // the service bean to be used in the test case
    @Autowired
    private HomeService service;
    
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
    	// this sets the expectations for the service method when called
    	// what to reutrn
    	//when(service.greet()).thenReturn("Hello Mock");
    	// here actual call is made to the rest api and 
    	// expectations are asserted
    	
    	assertThat(service).isNotNull();

    	        this.mockMvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
}





