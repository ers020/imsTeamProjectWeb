package com.revature.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

//Data Service
//Data Layer
//many names
//Delegate Design pattern
//ENTRY POINT between middle tier and backend
public class DataLayer {
	
	private Session session; //Session-per-request (best practice)
	private HibernateDAO dao;
	
	public DataLayer(){
		session = SessionFactoryManager.getInstance().openSession();
		dao = new HibernateDAO(session);//Session-per-request (best practice)
	}
	
	public void close(){
		if(session != null)
			session.close();
	}
	
	public void createRecord(Object obj){
		//can call multiple daos or dao methods
		Transaction tx = session.beginTransaction();
		
		try{
			dao.insert(obj); // can call multiple daos or dao methods
			tx.commit(); // commit 
		}catch(Throwable t){// or
			tx.rollback();// rollback (depending on result)
		}

		
	}
	
	
	
}
