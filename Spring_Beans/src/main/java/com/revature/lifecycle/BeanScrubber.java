package com.revature.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//Most likely one single post-processor per application, ever.
//Carried out before init and after init 
public class BeanScrubber implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean,
			String beanName) throws BeansException {
		if(bean instanceof LifecycleBean)
			System.out.println("postProcessBeforeInitialization for "+beanName);
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean,
			String beanName) throws BeansException {
		if(bean instanceof LifecycleBean)
			System.out.println("postProcessAfterInitialization for "+beanName);
		return bean;
	}

	
	
	
}
