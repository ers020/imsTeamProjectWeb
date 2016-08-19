package com.revature.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class ValidAdminFilter implements Filter{

	private FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		if(req.getSession().getAttribute("session") != null){
			UserBean userCurrent = (UserBean) req.getSession().getAttribute("session");
		
			//Roles 
			List<RoleBean> roles = new ArrayList<RoleBean>();
			DataService ds = new DataService();
			roles = ds.fillRolesBean(roles);
			//end Roles
			
			//User
			List<UserBean> user = new ArrayList<UserBean>();
			user = ds.fillUserBean(user, roles);
			//end User
			
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
			reimburseList = ds.fillReimburseBean(user, stats, type, reimburseList);
			request.setAttribute("reimbs", reimburseList);
			
			
			if(userCurrent.getRole().getRoleId() == 1){
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
		
	}


}
