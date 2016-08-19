package com.revature.annotated.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bd")
public class BusinessDelegate {
	@Autowired
	private DataService ds;
	
	public void setDs(DataService ds) {
		this.ds = ds;
	}

	public DataService getDs() {
		return ds;
	}

	
}
