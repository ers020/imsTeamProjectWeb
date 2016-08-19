package com.revature.app;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Classroom;
import com.revature.beans.Course;
import com.revature.beans.Instructor;
import com.revature.beans.Student;
import com.revature.beans.Textbook;
import com.revature.hibernate.SessionFactoryManager;

public class CourseManagement {

	private Session session; 
	
	public static void main(String[] args) {
		CourseManagement app = new CourseManagement();
		app.session = SessionFactoryManager.getInstance().openSession();
		Transaction tx = app.session.beginTransaction();
		
		// logic 
		Classroom classroom = new Classroom(1, 300, "John Adams");
		app.session.save(classroom);
		
		Instructor bill = new Instructor(1, "Bill Gates", "CS",
				null, classroom);
		app.session.save(bill);
		
		Set<Textbook> books = new HashSet<Textbook>();
		Textbook headFirst = new Textbook(1, "343y795320y723", "Head First Java", "Dan Pickles", 2005, null);
		books.add(headFirst);
		
		app.session.save(headFirst);
		
		Course java = new Course(1, "Intro to Java", 3, null, bill, books);
		//end logic
		
		app.session.save(java);//persisted object
		
		Set<Course> courses = new HashSet<Course>();
		courses.add(java);
		
		Student howie = new Student(1, "Howard Johnson", "IT", new Date(), courses);
		Student randy = new Student(1, "Randolf Scott", "IT", new Date(), courses);
		
		app.session.save(howie);
		app.session.save(randy);
		
		tx.commit();
		
	}
}
