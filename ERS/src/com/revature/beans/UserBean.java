package com.revature.beans;

public class UserBean {
	private int id;
	private String userName;
	private String password;
	private String fName;
	private String lName;
	private String email;
	private RoleBean role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public RoleBean getRole() {
		return role;
	}
	public void setRoleId(RoleBean role) {
		this.role = role;
	}
	
	
	public UserBean(){
		super();
	}
	
	public UserBean(String username, String password) {
		super();
		this.userName = username;
		this.password = password;
		
	}
	public UserBean(int id, String username, String fName, String lName, String email,
			RoleBean role) {
		super();
		this.id = id;
		this.userName = username;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.role = role;
		
	}
	public UserBean(int id, String username) {
		super();
		this.id = id;
		this.userName = username;
	}
	public UserBean(int id, String fName, String lName) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}
	
	
	
}
