package com.revature.app;

import java.util.Date;

import com.revature.beans.Employee;
import com.revature.hibernate.DataLayer;

public class ApplicationTierComponentThatNeedsDatabaseAccess {

	public static void main(String[] args) {
		Employee object = new Employee(123231123, "Tom", "Dillinger", 65000, new Date(), true);
		
		DataLayer dataSL = new DataLayer();
		dataSL.createRecord(object);
	}
	
}
