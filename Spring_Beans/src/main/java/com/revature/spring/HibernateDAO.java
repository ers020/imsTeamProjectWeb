package com.revature.spring;

public class HibernateDAO implements DAO{

	private String str;
	
	
	public void crud() {
		System.out.println(str);
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	

	
}
