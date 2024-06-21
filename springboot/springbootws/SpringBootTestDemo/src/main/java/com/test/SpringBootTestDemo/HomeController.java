package com.test.SpringBootTestDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired
	HomeService service;
	
//	public HomeController(HomeService service) {
//		this.service = service;
//	}
	@RequestMapping("/")
	 public @ResponseBody String greeting() {
	        return service.greet();
	}
}
