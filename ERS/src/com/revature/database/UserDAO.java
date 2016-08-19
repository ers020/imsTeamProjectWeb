package com.revature.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.beans.RoleBean;
import com.revature.beans.UserBean;

public class UserDAO {

	private static Properties columns;
	
	static{
		columns = new Properties();
		try {
			columns.load(
					UserDAO.class.getClassLoader()
					.getResourceAsStream("ers_users.properties")
					
					);
		} catch (IOException e) {e.printStackTrace();}
	}

	public UserDAO() {
		
	}

	public UserBean getUserBean(Connection conn, String username, List<RoleBean> roles) {

		UserBean user = null;
		
		String query="SELECT * "
				+ "FROM ERS_USERS "
				+ "WHERE ERS_USERNAME =? ";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				RoleBean roleTemp = null;
				
				//get Role object
				for(RoleBean r : roles){
					if (r.getRoleId() == rs.getInt(columns.getProperty("roleId"))){
						 roleTemp = r;
					}
				}
				
				 user = new UserBean(
						
						rs.getInt(columns.getProperty("userId")),
						username,
						rs.getString(columns.getProperty("fName")),
						rs.getString(columns.getProperty("lName")),
						rs.getString(columns.getProperty("email")),
						roleTemp
						);
				
			}
			return user;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public List<UserBean> userBeanList(Connection conn, List<RoleBean> roles) {
		
		List<UserBean> users = new ArrayList<UserBean>();
		UserBean user = null;
		//change tonight
		String query="SELECT * "
				+ "FROM ERS_USERS ";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				
				RoleBean roleTemp = null;
				
				//get Role object
				for(RoleBean r : roles){
					if (r.getRoleId() == rs.getInt(columns.getProperty("roleId"))){
						 roleTemp = r;
					}
				}
				
				 user = new UserBean(
						
						rs.getInt(columns.getProperty("userId")),
						rs.getString(columns.getProperty("name")),
						rs.getString(columns.getProperty("fName")),
						rs.getString(columns.getProperty("lName")),
						rs.getString(columns.getProperty("email")),
						roleTemp
						);
				 users.add(user);
			}
			
			return users;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); return null;
		}
		
	}

	public boolean validateUser(Connection conn, String username, String password) {
		
		boolean valid = false;
		String encrypted = new String();
		String tempName = new String();
		
		String query = "SELECT ERS_USERNAME, ERS_PASSWORD "
				+ "FROM ERS_USERS "
				+ "WHERE ERS_USERNAME=? ";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			
			
			while(rs.next()){
				
				tempName = rs.getString(columns.getProperty("name"));
				encrypted = rs.getString(columns.getProperty("pass"));
				
			}
			
			if(tempName.equals(username)){
				
				if (BCrypt.checkpw(password, encrypted)){
					
					valid = true;
				} 
			}else
				valid = false;
			
			return valid;
			
		} catch (SQLException e) {e.printStackTrace(); return false;}
		
	}

	

}
	

