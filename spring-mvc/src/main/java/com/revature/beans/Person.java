package com.revature.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.NotEmpty;
import org.springframework.stereotype.Controller;

@Controller
public class Person {
	
	
	@Size(min=1, message="Cannot be empty")
	private String name;
	@Min(value=0, message="Must be at least 0")
	@Max(value=120, message="Must be under 120")
	private int age;
	@NotEmpty(message="Email is required")
	@Pattern(message="Invalid email",
			regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Person() {
		super();
	}
	public Person(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
}
