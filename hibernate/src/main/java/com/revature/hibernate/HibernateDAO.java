package com.revature.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Employee;
import com.revature.beans.Student;

public class HibernateDAO {
	
	private Session session;
	
	public HibernateDAO(Session session) {
		this.session = session;
	}

	public void insert(Object obj){
		// discrete process
		session.save(obj);
	}
	
	public Employee getById(int id){
		Query query = session.createQuery("from Employee where id = :id");
		query.setInteger("id", id);
		return (Employee) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees(){
		Query query = session.createQuery("from Employee");
		return query.list();
	}
	
	public List<Student> getStudentsByMajor(String major){
		Query query = session.createQuery("from Student where major = :major");
		query.setString("major", major);
		return query.list();
	}
	
}
