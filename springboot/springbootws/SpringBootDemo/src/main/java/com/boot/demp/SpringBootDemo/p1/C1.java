package com.boot.demp.SpringBootDemo.p1;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Size;

@Component
public class C1 {

	@Size
	int x;
	public C1() {
		System.out.println("C1 default");
	}
}
