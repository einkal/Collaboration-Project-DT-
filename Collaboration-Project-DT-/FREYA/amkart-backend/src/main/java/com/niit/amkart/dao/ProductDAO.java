package com.niit.amkart.dao;

import java.util.List;

import com.niit.amkart.model.Category;
import com.niit.amkart.model.Product;

public interface ProductDAO {
public List<Product> list();
	
	public Product get(String productName);
	
	public Product getByID(int productID);
	
	public boolean save(Product product);
	
	public boolean update(Product product);
	
	public boolean delete(Product product);
}
