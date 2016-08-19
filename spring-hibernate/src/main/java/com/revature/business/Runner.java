package com.revature.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Pickle;
import com.revature.data.DataService;

public class Runner {
	
	public static void main(String[] args) {
		List<Pickle> jar = new ArrayList<Pickle>();
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("spring-beans.xml");
		DataService service = (DataService) ctxt.getBean("dataService");
		for(int i = 0; i < 10; i++){
			if(i == 300){
				throw new RuntimeException();
			}
			jar.add(new Pickle("dill", "spear", "Dan", 5));
		}
		service.batchInsert(jar);
		System.out.println("SUCCESS!");
		
	}
}
