package com.example.demo.control;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service
public class DemoService {
	@Autowired
	private  ApplicationContext applicationContext;
	
	private DemoService dproxy;
	
	@PostConstruct
	private void setSelf() {
		dproxy = (DemoService) applicationContext.getBean("demoService");
	}

	public boolean a() {
		dproxy.b();
		return false;
		
	}
	
	public void b() {
		System.out.println("11111111111111");
	}

}
