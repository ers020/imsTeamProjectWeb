package com.revature.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.revature.beans.ReimburseBean;
import com.revature.beans.RoleBean;
import com.revature.beans.StatusBean;
import com.revature.beans.TypeBean;
import com.revature.beans.UserBean;
import com.revature.database.ReimbursementDAO;
import com.revature.database.RoleDAO;
import com.revature.database.StatusDAO;
import com.revature.database.TypeDAO;
import com.revature.database.UserDAO;
import com.revature.service.ServiceLocatorReimb;
import com.revature.service.ServiceLocatorRole;
import com.revature.service.ServiceLocatorStatus;
import com.revature.service.ServiceLocatorType;
import com.revature.service.ServiceLocatorUser;

/*
 * 	// connect to a database
	//Example: Connection conn = DriverManager.getConnection(..);
			// open a transaction
			// call 3-5 DAO methods
	//Example: new HelloDAO(conn).insert(model);
	//Example new GoodbyeDAO(conn).doWOrk();
			// commit/rollback transaction
			//DONE
	
 */

public class DataService {

	public UserBean getUserBean(String username, UserBean user, List<RoleBean> roles) {
		
		try {
			Connection conn = ServiceLocatorUser.getDemoDatabase().getConnection();
			conn.setAutoCommit(false);
			UserDAO userDao = new UserDAO();
			user = userDao.getUserBean(conn, username, roles);
			
			conn.close();
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();return null;
		}
	}

	public List<StatusBean> fillStatusBean(List<StatusBean> status) {
		try {
			Connection conn = ServiceLocatorStatus.getDemoDatabase().getConnection();
			conn.setAutoCommit(false);
			StatusDAO statusDao = new StatusDAO();
			status = statusDao.fillBean(conn);
			
			conn.close();
			return status;
			
		} catch (SQLException e) {
			e.printStackTrace();return null;
		}
	}

	public List<TypeBean> fillTypeBean(List<TypeBean> type) {
		try {
			Connection conn = ServiceLocatorType.getDemoDatabase().getConnection();
			conn.setAutoCommit(false);
			TypeDAO typeDao = new TypeDAO();
			type = typeDao.fillBean(conn);
			
			conn.close();
			return type;
			
		} catch (SQLException e) {
			e.printStackTrace();return null;
		}
	}

	public List<RoleBean> fillRolesBean(List<RoleBean> roles) {
		try {
			Connection conn = ServiceLocatorRole.getDemoDatabase().getConnection();
			conn.setAutoCommit(false);
			RoleDAO roleDao = new RoleDAO();
			roles = roleDao.fillRoleBean(conn);
			
			conn.close();
			return roles;
			
		} catch (SQLException e) {
			e.printStackTrace();return null;
		}
	}

	public List<UserBean> fillUserBean(List<UserBean> users,List<RoleBean> roles) {
		
		try {
			
			Connection conn = ServiceLocatorUser.getDemoDatabase().getConnection();
			conn.setAutoCommit(false);
			UserDAO userDao = new UserDAO();
			users = userDao.userBeanList(conn, roles);
			
			conn.close();
			return users;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public List<ReimburseBean> fillReimburseBean(List<UserBean> user, List<StatusBean> stats, List<TypeBean> type,
			List<ReimburseBean> reimburseList) {
		try {
			
			Connection conn = ServiceLocatorReimb.getDemoDatabase().getConnection();
			conn.setAutoCommit(false);
			ReimbursementDAO reimbDao = new ReimbursementDAO();
			reimburseList = reimbDao.getAdminList(conn, user, stats, type);
			
			conn.close();
			return reimburseList;
			
		} catch (SQLException e) {e.printStackTrace(); return null;}
		
	}

	public List<ReimburseBean> fillReimburseBeanForIndiviual(UserBean thisUser, List<UserBean> user, 
			List<StatusBean> stats, List<TypeBean> type, List<ReimburseBean> reimburseList) {
		
		try {
			
			Connection conn = ServiceLocatorReimb.getDemoDatabase().getConnection();
			conn.setAutoCommit(false);
			ReimbursementDAO reimbDao = new ReimbursementDAO();
			reimburseList = reimbDao.getClientList(conn, thisUser, user, stats, type);
			
			conn.close();
			return reimburseList;
			
		} catch (SQLException e) {e.printStackTrace(); return null;}
	}

	public boolean validateUser(String username, String password) {
		
		boolean validate = false;
		
		try {
			Connection conn = ServiceLocatorUser.getDemoDatabase().getConnection();	
			conn.setAutoCommit(false);
			UserDAO userDao = new UserDAO();
			validate = userDao.validateUser(conn, username, password);
			
			conn.close();
			return validate;
			
		} catch (SQLException e) {e.printStackTrace(); return false;}
	}

	public ReimburseBean editReimb(int id, List<TypeBean> type, List<StatusBean> status, ReimburseBean reimBean) {
		try {
			
			Connection conn = ServiceLocatorReimb.getDemoDatabase().getConnection();
			conn.setAutoCommit(false);
			ReimbursementDAO reimbDao = new ReimbursementDAO();
			reimBean = reimbDao.editReimb(conn, type, status, id);
			
			conn.close();
			return reimBean;
			
		} catch (SQLException e) {e.printStackTrace();return null;}
		
	}

	public boolean inputNewClaim(int userId, double amount, String desc, int type, Date date, boolean submitted) {
 		
 		try {
 			
	
 			Connection conn = ServiceLocatorReimb.getDemoDatabase().getConnection();
 			conn.setAutoCommit(false);
 			ReimbursementDAO reimbDao = new ReimbursementDAO();
 			submitted = reimbDao.inputNewClaim(conn, userId, amount, desc, type, date);
 			
 			conn.close();
 			return submitted;
 			
 		} catch (SQLException e) {e.printStackTrace(); return false;}
 	}

	public void approveClaim(int id, int resolverId, Date date) {
	
	try {
		
		Connection conn = ServiceLocatorReimb.getDemoDatabase().getConnection();
		conn.setAutoCommit(false);
		ReimbursementDAO reimbDao = new ReimbursementDAO();
		reimbDao.approveClaim(conn, id, resolverId, date);
		
		
		conn.close();
		
	} catch (SQLException e) {e.printStackTrace(); }
		
	
	
	}

	public void denyClaim(int id, int resolverId, Date date) {
		
		try {
			
			Connection conn = ServiceLocatorReimb.getDemoDatabase().getConnection();
			conn.setAutoCommit(false);
			ReimbursementDAO reimbDao = new ReimbursementDAO();
			reimbDao.denyClaim(conn, id, resolverId, date);
			
			
			conn.close();
			
		} catch (SQLException e) {e.printStackTrace(); }
			
	}

}
	

