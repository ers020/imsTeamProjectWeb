package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.data.DAO;
import com.revature.data.JSONConverter;
import com.revature.data.Trainee;

public class TraineeAJAXServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		switch(req.getRequestURI()){
			case"/JSON/ajax/get":{
				//get user input
					int id = Integer.parseInt(req.getParameter("query"));
					// find trainee in database
					Trainee obj = new DAO().getById(id);
					// convert result to json
					String json =  new JSONConverter().getTraineeJSON(obj);
					//send json to user (ajax response)
					//attach json to HTTP response body
					resp.getWriter().println(json); 
					break;
				}
			case"/JSON/ajax/getall":{
					//get list
					List<Trainee> obj = new DAO().getAll();
					Trainee[] arrObj = (Trainee[]) obj.toArray();
					
					String json = new JSONConverter().getTraineeJSONArray(arrObj);
					
					resp.getWriter().println(json);
					
					break;
				}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getRequestURI().equals("/JSON/ajax/post")){
			//read HTTP request body (which contains posted JSON data)
			//request.getInputStream() get the request BODY
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
							req.getInputStream()
			));
			//extract JSON string from ServletInputStream
			String json = "";
			if(reader != null){
				json = reader.readLine(); //reads the JSON from AJAX request
			}
			//parse the Trainee obj from JSON
			Trainee obj = new JSONConverter().getTraineeJSON(json);
			//save to "database"
			new DAO().insert(obj);
			
		}
			
		
	}
}
