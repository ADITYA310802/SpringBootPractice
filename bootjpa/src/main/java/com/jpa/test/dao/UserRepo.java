package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.user;

public interface UserRepo extends CrudRepository<user, Integer>{
	public List<user> findByName(String name);
	
	public List<user> findByNameAndCity(String name, String city);
	
	@Query("select u from user u")
	public List<user> gettAllUser();
	
	 

}
