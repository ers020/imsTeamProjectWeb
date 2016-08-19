package com.revature.annotated.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
	public static void main(String[] args) {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("annotations.xml");
		
		BusinessDelegate bd = (BusinessDelegate) ctxt.getBean("bd");
		System.out.println(bd.getDs());
		System.out.println(bd.getDs().getDao());
		System.out.println("Complete!");
		
	}
}
