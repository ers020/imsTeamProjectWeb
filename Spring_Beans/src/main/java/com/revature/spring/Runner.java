package com.revature.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); // << xml config 
		DataService service = (DataService)context.getBean("dataService");// <<<< access our Beans
		service.foo();
		
	}
}
