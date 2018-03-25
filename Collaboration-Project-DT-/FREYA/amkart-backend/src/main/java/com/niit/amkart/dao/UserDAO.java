package com.niit.amkart.dao;

import java.util.List;

import com.niit.amkart.model.User;

public interface UserDAO {

	public List<User> list();
	
	public User get(String email);
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean delete(User user);
	
}
