package com.niit.amkart.dao;

import java.util.List;

import com.niit.amkart.model.Category;
import com.niit.amkart.model.Product;


public interface CategoryDAO {
public List<Category> list();
	
	public Category get(String categoryName);
	
	public Category getByID(String id);
	
	public boolean save(Category category);
	
	public boolean update(Category category);
	
	public boolean delete(Category category);
	
	public Category searchByCategory(String categoryName);
}
