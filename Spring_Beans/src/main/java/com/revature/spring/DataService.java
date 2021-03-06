package com.revature.spring;

import org.springframework.beans.factory.annotation.Autowired;

//needs a DAO
public class DataService {

	
	@Autowired //look for a bean called as the same name as the property
	private DAO dao; //go find a bean called as "dao"

	// Setter-injection (dependency injection)
	public void setDao(DAO dao) {
		this.dao = dao;
		System.out.println("Setter injection");
	}
	//constructor injection
	
	public DataService(DAO dao) {
		super();
		this.dao = dao;
		System.out.println("Constructor injection");
	}
	
	public DataService() {
		super();
	}
	public void foo(){
		dao.crud();
	}

	
	
	
	
}
