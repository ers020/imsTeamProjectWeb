package com.revature.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");
		//startup this lifecycle for my beans
		System.out.println("IoC Contain started up!");
		LifecycleBean bean1 = (LifecycleBean) context.getBean("lifecycle"); //using my bean
		LifecycleBean bean2 = (LifecycleBean) context.getBean("lifecycle"); //using my bean
		
		bean1.setStr("✌(◕‿-)✌"); //change one bean
		
		System.out.println(bean1.getStr());  //Stateless Bean (singleton - doesn't need to stay in state)
		System.out.println(bean2.getStr());	// Stateful Bean (prototype - needs to stay in state)

		//whatever we need to do
		context.registerShutdownHook(); //power off!!!!!!!!!!1!
	}
}
