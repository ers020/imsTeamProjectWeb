package com.revature.beans;

public class TypeBean {
	private int typeId;
	private String type;
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public TypeBean() {
		super();
	}
	public TypeBean(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}
	
	
	
}
