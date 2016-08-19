package com.revature.annotated.beans;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class DAO {
	
	public DAO(){
		System.out.println("Instantiating DAO");
	}
}