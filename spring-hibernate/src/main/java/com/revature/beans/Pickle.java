package com.revature.beans;

import javax.persistence.*;

@Entity
public class Pickle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //HIBERNATE_SEQUENCE
	@Column(name="PICKLE_ID")
	private int id;
	@Column(name="PICKLE_FLAVOR")
	private String flavor;
	@Column(name="PICKLE_CUT")
	private String cut;
	@Column(name="PICKLE_BRAND")
	private String brand;
	@Column(name="PICKLE_WEIGHT")
	private double weight;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getCut() {
		return cut;
	}
	public void setCut(String cut) {
		this.cut = cut;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Pickle() {
		super();
	}
	public Pickle(String flavor, String cut, String brand, double weight) {
		super();
		this.flavor = flavor;
		this.cut = cut;
		this.brand = brand;
		this.weight = weight;
		
	}
	
	
	
	
}
