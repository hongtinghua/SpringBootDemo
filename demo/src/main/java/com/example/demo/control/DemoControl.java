package com.example.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoControl {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value="/hello")
	public String hello() {
		demoService.a();
		return "11111";
		
	}
	
	

}
