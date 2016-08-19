package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.app.DataService;
import com.revature.beans.RoleBean;
import com.revature.beans.UserBean;
/**
 * Front Controller
 * """"""""""""Controller"""""""""""""""
 * Examples!!!!!!!!!!
 */


public class RequestHelper {

	
	public static void process(HttpServletRequest request, 
			HttpServletResponse response) {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()){
		
			case"/ERS/secure/admin/main.do":{
			
				Locale locale = new Locale("en", "us");
				ResourceBundle rb = ResourceBundle.getBundle("main", locale);
				request.setAttribute("mainProp", rb);
				System.out.println(rb);
				
				try {
				request.getRequestDispatcher("../main.jsp").forward(request, response);
				} catch (ServletException e) {e.printStackTrace();} 
				catch (IOException e) {e.printStackTrace();}
			
				break;
			}
		
			case"/ERS/secure/client/main.do":{
			
				Locale locale = new Locale("en", "us");
				ResourceBundle rb = ResourceBundle.getBundle("main", locale);
				request.setAttribute("mainProp", rb);
				System.out.println(rb);
				
				try {
					request.getRequestDispatcher("../main.jsp").forward(request, response);
				} catch (ServletException e) {e.printStackTrace();} 
				catch (IOException e) {e.printStackTrace();}
			
				break;
			}
		
		
			case"/ERS/secure/main.do":{
				
				
				Locale locale = new Locale("en", "us");
				ResourceBundle rb = ResourceBundle.getBundle("main", locale);
				request.setAttribute("mainProp", rb);
				System.out.println(rb);
				
				try {
					request.getRequestDispatcher("../secure/main.jsp").forward(request, response);
				} catch (ServletException e) {e.printStackTrace();} 
				catch (IOException e) {e.printStackTrace();}
				
				break;
			}
			
			case"/ERS/login.do":{
				
				String username = request.getParameter("user");
				String password = request.getParameter("pass");
				
				//Validate
				DataService ds = new DataService();	
				
				//Get boolean to compare
				boolean valid = false;
				valid = ds.validateUser(username, password);
				
				if(!valid){
					
					try {
						request.setAttribute("loginFail", "Login failed. Try again.");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					} catch (IOException | ServletException e) {e.printStackTrace();}
					
					
				}else{
				
				
				//Roles 
				List<RoleBean> roles = new ArrayList<RoleBean>();
				roles = ds.fillRolesBean(roles);
				//end Roles
				
				//User
				UserBean user = null;
				user = ds.getUserBean(username, user, roles);
				request.getSession().setAttribute("session", user);
				
				try {
					response.sendRedirect("/ERS/secure/main.jsp");
				} catch (IOException e) {e.printStackTrace();}
				
				}
				
				break;
			}
			
			case"/ERS/secure/admin.do":{
				
				try {
					response.sendRedirect("/ERS/secure/admin/adminView.jsp"); 
				} catch (IOException e) {e.printStackTrace();}
				break;
			}
			
			case"/ERS/secure/admin/denyEntry.do":{
				
				DataService ds = new DataService();
				//get resolver information
				UserBean resolver = (UserBean) request.getSession().getAttribute("session");
				
				//get time!
 				Date date = new Date();
				int id = Integer.parseInt(request.getParameter("id"));
				int resolverId = resolver.getId();
				
				
				ds.denyClaim(id, resolverId, date);
				
				try {
					response.sendRedirect("/ERS/secure/admin/adminView.jsp");
					
				} catch (IOException e) {e.printStackTrace();
				}
				
				break;
			}
			
			case"/ERS/secure/admin/approveEntry.do":{
				
				DataService ds = new DataService();
				//get resolver information
				UserBean resolver = (UserBean) request.getSession().getAttribute("session");
				
				//get time!
 				Date date = new Date();
				int id = Integer.parseInt(request.getParameter("id"));
				int resolverId = resolver.getId();
				
				ds.approveClaim(id, resolverId, date);
				
				try {
					response.sendRedirect("/ERS/secure/admin/adminView.jsp");
					
				} catch (IOException e) {e.printStackTrace();}
				
				break;
			}
			
			case"/ERS/secure/client/clientView.do":{
				
				try {
					response.sendRedirect("/ERS/secure/client/clientTable.jsp");
				} catch (IOException e) {e.printStackTrace();}
				
				break;
			}
			
			case"/ERS/secure/clientView.do":{
				
				try {
					response.sendRedirect("/ERS/secure/client/clientTable.jsp");
				} catch (IOException e) {e.printStackTrace();}
				
				break;
			}
			
			
			case"/ERS/secure/client/clientClaim.do":{
				
				try {
					response.sendRedirect("/ERS/secure/client/clientClaim.jsp");
				} catch (IOException e) {e.printStackTrace();}
				
				break;
				
			}
			
			case"/ERS/secure/clientClaim.do":{
				System.out.println("here,");
				try {
					response.sendRedirect("/ERS/secure/client/clientClaim.jsp");
				} catch (IOException e) {e.printStackTrace();}
				
				break;
				
			}
			
			case"/ERS/secure/client/addClaim.do":{
 				
 				DataService ds = new DataService();
 				
 				//get id and other variables
 				UserBean user = (UserBean) request.getSession().getAttribute("session");
 				int userId = user.getId();
 				double amount = Double.parseDouble(request.getParameter("amount"));
 				String desc = request.getParameter("desc");
 				int type = Integer.parseInt(request.getParameter("type"));
 				
 				//get time!
 				Date date = new Date();
 				
 				boolean submitted = false;
 				submitted = ds.inputNewClaim(userId, amount, desc, type, date, submitted);
 				
 				try {
 					response.sendRedirect("/ERS/secure/client/success.jsp");
				} catch (IOException e) {e.printStackTrace();}
 				break;
 			}
			
			case"/ERS/secure/client/logout.do":{
				
				request.getSession().invalidate();
				
				try {
					response.sendRedirect("../../logout.jsp");
				} catch (IOException e) {e.printStackTrace();}
				
				break;
			}
			
			case"/ERS/secure/admin/logout.do":{
				
				request.getSession().invalidate();
				
				try {
					response.sendRedirect("../../logout.jsp");
				} catch (IOException e) {e.printStackTrace();}
				
				break;
			}
			
			case"/ERS/secure/logout.do":{
				
				request.getSession().invalidate();
				
				try {
					response.sendRedirect("../logout.jsp");
				} catch (IOException e) {e.printStackTrace();}
				
				break;
			}	
			
			default:{
				throw new IllegalArgumentException("Not a valid URI!");
			}
		
		}//end switch
		
	}//end process
	
}//end RequestHelper
