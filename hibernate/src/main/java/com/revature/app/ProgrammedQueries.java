package com.revature.app;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Student;
import com.revature.hibernate.SessionFactoryManager;

public class ProgrammedQueries {

	public static void main(String[] args) {
		//programmatically build query
		@SuppressWarnings("unused")
		String sql = "Select * from tablename where id = ?";
		//Criteria - lowers syntax errors
		Session session = SessionFactoryManager.getInstance().openSession();
		
//		criteria.add(Restrictions.eq("name", "Randolph Scott"));
//		//criteria.addOrder(Order.desc("id"));
//		//criteria.add(Restrictions.like("name", "%" + "ohn" + "%"));
//		//criteria.add(Restrictions.lt("enrollmentDate", new Date()));	
//		Calendar yesterday = Calendar.getInstance();
//		yesterday.set(2016, Calendar.AUGUST, 11, 23, 59);
//		criteria.add(Restrictions.le("enrollmentDate", yesterday.getTime()));	
//		
//		
//		//use tree set to order it correctly
		Criteria criteria = session.createCriteria(Student.class); //specify table
		/////////////////////////////Projections - performance aggregate functions
		criteria.add(Restrictions.eq("name", "Howard Johnson"));
		criteria.setProjection(Projections.count("id"));
		System.out.println(criteria.uniqueResult() + " students enrolled");
		
		
//		Set<Student> results = new HashSet<Student>(criteria.list());
		
//		for(Student a : results){
//			System.out.println(a.getName() + " " + a.getId()+ " " + a.getMajor());
//			}
//		
//		//Complex queries are easier
//		Criteria crit = session.createCriteria(Student.class).add(Restrictions.between("id", 1, 100))
//				.add(Restrictions.lt("enrollmentDate", yesterday.getTime()))
//				.add(Restrictions.like("name", "Dan%"))
//				.add(Restrictions.or(
//						Restrictions.lt("id", 100), 
//						Restrictions.gt("id", 500)))
//				.add(Restrictions.and(
//						Restrictions.eq("major", "IT"), 
//						Restrictions.eq("minor", "Business")))
//				.setFetchMode("courses", FetchMode.LAZY)
//				.addOrder(Order.asc("name"));
//		
		
	}
}
