package com.revature.service;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.revature.database.UserDAO;


public class ServiceLocatorUser {

	public static DataSource getDemoDatabase() {
		try{
			Properties environmentProps = new Properties();
			environmentProps.load(
					UserDAO.class.getClassLoader().getResourceAsStream("jndi.properties")
				);
			Context ctxt = new InitialContext(environmentProps);
								//^^^JNDI lookup obj
			DataSource ds = (DataSource) ctxt.lookup("db/demo");
			
			return ds;
			
			} catch(Exception e){e.printStackTrace(); return null;}
		}
	}
	

