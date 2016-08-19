package com.revature.beans;

public class RoleBean {
	private int roleId;
	private String role;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public RoleBean() {
		super();
	}
	public RoleBean(int roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}
	
	public RoleBean(int roleId) {
		this.roleId = roleId;
		
		if(roleId == 1){
			this.role = "MANAGER";
		}
		else{
			this.role = "WORKER";
		}
			
		
	}
	@Override
	public String toString() {
		return "RoleBean [roleId=" + roleId + ", role=" + role + "]";
	}
	
	
	
}
