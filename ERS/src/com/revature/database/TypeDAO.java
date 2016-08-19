package com.revature.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.revature.beans.TypeBean;

public class TypeDAO {
	
	private static Properties columns;
	
	static{
		columns = new Properties();
		try {
			columns.load(
					TypeDAO.class.getClassLoader()
					.getResourceAsStream("reimb_type.properties")
					
					);
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public List<TypeBean> fillBean(Connection conn){
		
		List<TypeBean> typeList = new ArrayList<TypeBean>();
		TypeBean type = null;
		
		String query = "SELECT * "
				+ "FROM ERS_REIMBURSEMENT_TYPE";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				type = new TypeBean(
						
						rs.getInt(columns.getProperty("typeId")),
						rs.getString(columns.getProperty("type"))
						
						);
				typeList.add(type);
			}
			return typeList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return typeList;
		
	}

	
}

