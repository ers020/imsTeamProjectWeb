package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.revature.app.DataService;
import com.revature.beans.ReimburseBean;
import com.revature.beans.RoleBean;
import com.revature.beans.StatusBean;
import com.revature.beans.TypeBean;
import com.revature.beans.UserBean;

public class ValidClientFilter implements Filter {

	private FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;

		if(req.getSession().getAttribute("session") != null){
			
			DataService ds = new DataService();
			
			UserBean thisUser = null;
			//User - Author
			thisUser = (UserBean) req.getSession().getAttribute("session");
			
			//User - Resolver
			//Roles 
			List<RoleBean> roles = new ArrayList<RoleBean>();
			roles = ds.fillRolesBean(roles);
			//end Roles
			
			//User
			List<UserBean> user = new ArrayList<UserBean>();
			user = ds.fillUserBean(user, roles);
			//end User
			//end User - Resolver
			
			//Status
			List<StatusBean> stats = new ArrayList<StatusBean>();
			stats = ds.fillStatusBean(stats);
			//end Status
			
			//Type
			List<TypeBean> type = new ArrayList<TypeBean>();
			type = ds.fillTypeBean(type);
			//end Type	
			
			
			//Reimbursement
			List<ReimburseBean> reimburseList = new ArrayList<ReimburseBean>();
			reimburseList = ds.fillReimburseBeanForIndiviual(thisUser, user, stats, type, reimburseList);
			request.setAttribute("individualReimbs", reimburseList);
			//end Reimbursement
			
			//list of types for clientClaim dropdownlist
			request.setAttribute("type", type);
			
			if(thisUser.getRole().getRoleId() == 2){
				chain.doFilter(request, response); // forwards to requested URI
			
			}else{
				req.getServletContext()
				.getRequestDispatcher(config.getInitParameter("loginPage"))
				.forward(req, response);
			}
			
		}else{
			req.getServletContext()
			.getRequestDispatcher(config.getInitParameter("loginPage"))
			.forward(req, response);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
