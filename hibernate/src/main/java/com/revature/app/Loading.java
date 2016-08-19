package com.revature.app;

import java.util.Date;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.revature.beans.Course;
import com.revature.beans.Student;
import com.revature.hibernate.SessionFactoryManager;

public class Loading {
	
	public static void main(String[] args) {
		Session session = SessionFactoryManager.getInstance().openSession();
		
		
		//Native SQL
		String sql ="SELECT * FROM UOP_STUDENT WHERE STUDENT_ID=?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setInteger(0, 63);
		//bind the results of the query to a particular class/ Hibernate-managed class (annotated, etc.)
		query.addEntity(Student.class);
		

		
		Date start = new Date();
		
		Student abc = (Student) query.uniqueResult();
		Set<Course> classes = abc.getEnrolledCourses();
		
		Date end = new Date();
		
		System.out.println(end.getTime() - start.getTime());
		System.out.println(classes.size());
		System.out.println(abc.getName());
		
		
		//HQL ((OO version of SQL) compared to SQL
//		String sql = "SELECT * FROM UOP_STUDENT WHERE STUDENT_ID = ?";
//		String hql = "FROM com.revature.beans.Student WHERE major = :param";
		//String hql = "FROM com.revature.beans.Student WHERE id = :param"; //SELECT * is implicit

		//query.setInteger("param", 63);
		//Student record = (Student) query.uniqueResult();
		//System.out.println(record.getName());
	
		//LOAD and GET
		
		//Student randolph = (Student)session.get(Student.class, 63);
													//^Type	 //^PK
		
		//Student randolph = (Student)session.load(Student.class, 50);
	
		//System.out.println("Get " + randolph.getName() + " from DB");
	}
}
