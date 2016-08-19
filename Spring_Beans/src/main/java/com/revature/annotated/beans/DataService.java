package com.revature.annotated.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ds")
public class DataService {
	@Autowired
	private DAO dao;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public DAO getDao() {
		return dao;
	}
	
	
}
