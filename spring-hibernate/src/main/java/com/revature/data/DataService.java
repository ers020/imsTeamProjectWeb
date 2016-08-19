package com.revature.data;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Pickle;

public class DataService {
	
	private DAO dao; 
	public void setDao(DAO dao){
		this.dao = dao;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED,
			rollbackFor=Throwable.class,
			propagation=Propagation.REQUIRES_NEW) //Propagation.REQUIRES_NEW saying that it needs a new transaction, so it will spawn a new transaction.
	public void batchInsert(List<Pickle> pickleJar){
		for(Pickle p : pickleJar){
			dao.save(p);
		}
	}
}
