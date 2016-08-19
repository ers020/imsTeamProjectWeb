package com.revature.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.revature.beans.RoleBean;

public class RoleDAO {
	
	private static Properties columns;
	
	public RoleDAO(){
		columns = new Properties();
		try {
			columns.load(
					RoleDAO.class.getClassLoader()
					.getResourceAsStream("reimb_role.properties")
					
					);
		} catch (IOException e) {e.printStackTrace();}
	}

	public List<RoleBean> fillRoleBean(Connection conn) {
		
		List<RoleBean> roles = new ArrayList<RoleBean>();
		RoleBean role = null;
		
		String query = "SELECT * "
				+ "FROM ERS_USER_ROLES";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				role = new RoleBean(
						
						rs.getInt(columns.getProperty("roleId")),
						rs.getString(columns.getProperty("role"))
						
						);
				roles.add(role);
			}
			return roles;
			
		} catch (SQLException e) {e.printStackTrace(); return null;}
	}//end fillRoleBean
}
