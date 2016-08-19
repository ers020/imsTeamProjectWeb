package com.revature.controllers;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Person;

public class AJAXController {
	
	private List<Person> people = new Vector<Person>();
	
	@RequestMapping(method=RequestMethod.GET, value="getAll.do",
					produces="application/json")
	@ResponseBody	//write return value directly to HTTP response in the specified content-type(produces=content-type)
	public List<Person> getPeople(){
		return people;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="insert.do",
					consumes="application/json")
	@ResponseBody	//leave Britney alone! I mean, us alone view resolver
	public void  insertPerson(@RequestBody Person person){
							//^^^ Spring use Jackson to Marshall into person
		people.add(person);
	}
	@RequestMapping(method=RequestMethod.GET, value="get.do")
	public Person getByEmail(@RequestParam("email") String email){
		return this.findByEmail(email);
	}
		
	private Person findByEmail(String email){
		for(Person p : people){
			if(p.getEmail().equals(email)){
				return p;
			}
		}
		return null;//could not find
	}
}
