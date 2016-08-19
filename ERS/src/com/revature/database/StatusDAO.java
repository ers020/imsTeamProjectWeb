package com.revature.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.revature.beans.StatusBean;

public class StatusDAO {

	private static Properties columns;
	
	static{
		columns = new Properties();
		try {
			columns.load(
					StatusDAO.class.getClassLoader()
					.getResourceAsStream("reimb_status.properties")
					
					);
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public List<StatusBean> fillBean(Connection conn) {
		
		List<StatusBean> stats = new ArrayList<StatusBean>();
		StatusBean status = null;
		
		String query = "SELECT * "
				+ "FROM ERS_REIMBURSEMENT_STATUS";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				status = new StatusBean(
						
						rs.getInt(columns.getProperty("statusId")),
						rs.getString(columns.getProperty("status"))
						
						);
				stats.add(status);
			}
			return stats;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stats;
		
	}


}

