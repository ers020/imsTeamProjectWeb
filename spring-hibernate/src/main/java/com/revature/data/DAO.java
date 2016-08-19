package com.revature.data;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Pickle;

public class DAO {
	
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			rollbackFor=Throwable.class,
			propagation=Propagation.REQUIRED)
	public void save(Pickle pickle){
		sf.getCurrentSession().save(pickle);
	}
}
