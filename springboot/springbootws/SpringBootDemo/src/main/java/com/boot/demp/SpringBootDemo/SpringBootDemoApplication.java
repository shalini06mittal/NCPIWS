package com.boot.demp.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.boot.demp.SpringBootDemo.p1.C1;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
	ApplicationContext c=	SpringApplication.run(SpringBootDemoApplication.class, args);
	c.getBean(C1.class).m2();
	}
	
	

}
