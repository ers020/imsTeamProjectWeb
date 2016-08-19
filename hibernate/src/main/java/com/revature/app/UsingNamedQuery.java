package com.revature.app;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.SessionFactoryManager;

public class UsingNamedQuery {
	
	public static void main(String[] args) {
		// DAO		
		Session session = SessionFactoryManager.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("indecisiveStudent");
		query.setInteger("id", 15);
		query.setString("newMajor", "CS");
		query.executeUpdate();
		tx.commit();
		System.out.println("Done");
	}
}
