package com.revature.beans;

public class StatusBean {
	
	private int statusId;
	private String status;
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public StatusBean() {
		super();
	}
	public StatusBean(int statusId) {
		super();
		this.statusId = statusId;
		if(statusId == 1){
			this.status = "PENDING";
		}
		else if(statusId == 2){
			this.status = "APPROVED";
		}
		else{
			this.status = "DENY";
		}
		
	}
	public StatusBean(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	
	
	
}
