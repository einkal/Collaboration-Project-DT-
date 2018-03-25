package com.niit.amkart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.amkart.dao.ProductDAO;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Product;
import com.niit.amkart.model.Supplier;
@Repository("ProductDAO")
@Transactional
public class ProductDaoImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list(); 
	}

	public Product get(String productName) {
		
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where productName='"+productName+"'").uniqueResult();
	}

	public boolean save(Product product) {
		System.out.println("Saving");
		sessionFactory.getCurrentSession().save(product);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	public boolean update(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	public boolean delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}
	
	public Product getByID(int productID) {
		 return (Product)sessionFactory.getCurrentSession().createQuery("from Product where productID='"+productID+"'").uniqueResult();

	}
}
