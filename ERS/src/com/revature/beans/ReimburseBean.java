package com.revature.beans;

import java.sql.Blob;
import java.util.Date;

public class ReimburseBean {
	private int id;
	private double amount;
	private Date submitted;
	private Date resolved;
	private String desc;
	private Blob receipt;
	private UserBean author;
	private UserBean resolver;
	private StatusBean status;
	private TypeBean type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}
	public Date getResolved() {
		return resolved;
	}
	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public UserBean getAuthor() {
		return author;
	}
	public void setAuthor(UserBean author) {
		this.author = author;
	}
	public UserBean getResolver() {
		return resolver;
	}
	public void setResolver(UserBean resolver) {
		this.resolver = resolver;
	}
	public StatusBean getStatus() {
		return status;
	}
	public void setStatus(StatusBean status) {
		this.status = status;
	}
	public TypeBean getType() {
		return type;
	}
	public void setType(TypeBean type) {
		this.type = type;
	}
	public ReimburseBean() {
		super();
	}
	public ReimburseBean(int id, double amount, Date submitted, Date resolved, String desc, Blob receipt,
			UserBean author, UserBean resolver, StatusBean status, TypeBean type) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.desc = desc;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	public ReimburseBean(int id, double amount, String desc, UserBean author, StatusBean status, TypeBean type) {
		super();
		this.id = id;
		this.amount = amount;
		this.desc = desc;
		this.author = author;
		this.status = status;
		this.type = type;
	}
	
	
	
	
}
