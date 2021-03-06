package com.revature.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryManager {

	//One SF per database
	private static SessionFactory sf;
	
	private SessionFactoryManager(){}
	
	public static synchronized SessionFactory getInstance(){
		
		if (sf == null){
			//Instantiation of SessionFactory (3.6)
			sf = new Configuration().configure().buildSessionFactory();
		}
		return sf;
	}
	
	
}
