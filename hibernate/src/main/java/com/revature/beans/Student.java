package com.revature.beans;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
//JPA
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name="UOP_STUDENT")
@NamedQueries({
	@NamedQuery(name="indecisiveStudents",
			query="update Student set major = :newMajor where id = :id")
})

@NamedNativeQueries({
	@NamedNativeQuery(name="getall", query="select * from")
})

public class Student {

	@Id
	@Column(name="STUDENT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dan")
	@SequenceGenerator(name="dan" , sequenceName="UOP_DAN_SEQ", initialValue=1000, allocationSize=10)
	private int id;
	@Column(name="FULL_NAME")
	private String name;
	@Column
	private String major;
	@Column(name="ENROLLMENT_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date enrollmentDate;
	
	/////MAPPING: not actually a database column/////
	// Left to Right --> this class to that class //
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="students") //mappedBy (look in other class)
	private Set<Course> enrolledCourses = new HashSet<Course>();
	
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
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	
	public Set<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	
	public void setEnrolledCourses(Set<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, String major, Date enrollmentDate, Set<Course> enrolledCourses) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
		this.enrollmentDate = enrollmentDate;
		this.enrolledCourses = enrolledCourses;
	}
	
	
	
}
