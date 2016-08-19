package com.revature.beans;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="UOP_INSTRUCTOR")
public class Instructor {

	@Id
	@Column(name="INSTRUCTOR_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="INSTRUCTOR_NAME")
	private String name;
	@Column(name="INSTRUCTOR_DEPT")
	private String department;
	@OneToMany(mappedBy="instructor")
	private Set<Course> assignedCourses;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DESIGNATED_CLASSROOM", unique=true)
	private Classroom classroom;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Set<Course> getAssignedCourses() {
		return assignedCourses;
	}
	
	public void setAssignedCourses(Set<Course> assignedCourses) {
		this.assignedCourses = assignedCourses;
	}
	
	public Classroom getClassroom() {
		return classroom;
	}
	
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	public Instructor() {
		super();
	}
	
	public Instructor(int id, String name, String department, Set<Course> assignedCourses, Classroom classroom) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.assignedCourses = assignedCourses;
		this.classroom = classroom;
	}
	
	
	
}
