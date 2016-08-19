package com.revature.web;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AuthLoginFilter implements Filter{

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
			chain.doFilter(request, response); // forwards to requested URI
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
