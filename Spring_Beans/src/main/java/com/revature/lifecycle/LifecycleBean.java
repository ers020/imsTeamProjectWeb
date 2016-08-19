package com.revature.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class LifecycleBean implements BeanNameAware, 
									BeanFactoryAware,
									InitializingBean,
									DisposableBean
{

	private String str;

	public String getStr() {
		return str;
	}
	
	//instantiate occurs calling the no-arg constructor
		public LifecycleBean() {
			super();
			System.out.println("Instantiate"); //1.
		}

	//setter injector
	public void setStr(String str) {
		this.str = str;
		System.out.println("Populate Properties");//2.
	}

	public LifecycleBean(String str) {
		super();
		this.str = str;
	}

	public void setBeanName(String beanName) {
		System.out.println("BeanNameAware's setBeanName: " + beanName); //3
		
	}

	public void setBeanFactory(BeanFactory bff) throws BeansException {
		System.out.println("BeanFactoryAware's setBeanFactory: " + bff); //4
		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean's afterPropertiesSet"); //5
		
	}
	public void eyenight(){
		System.out.println("Call custom init method"); //6
	}
	/////////////////////////////// Bean is in USE //////////////////////////////////

	public void destroy() throws Exception {
		System.out.println("DisposableBean's destroy()"); //7
		
	}
	
	//custom destroy method
	public void obliteration(){
		System.out.println("Call customer destroy method"); //8
	}
	
	
}
