package com.boot.demp.SpringBootDemo.p1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Size;

@Component
public class C1 {

	@Autowired
	private A a;
	@Size
	int x;
	public C1() {
		System.out.println("C1 default");
		
	}
	public void m2() {
		System.out.println(a);
		a.m1();
	}
}
