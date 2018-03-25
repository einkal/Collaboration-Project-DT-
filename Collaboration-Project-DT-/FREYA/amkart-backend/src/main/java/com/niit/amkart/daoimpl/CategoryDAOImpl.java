package com.niit.amkart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Product;
import com.niit.amkart.model.Supplier;
@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	public List<Category> list() 
	{
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category get(String categoryName) {
		return (Category)sessionFactory.getCurrentSession().createQuery("from Category where categoryName='"+categoryName+"'").uniqueResult();
	}

	public boolean save(Category category) {
		System.out.println("Saving");
		sessionFactory.getCurrentSession().save(category);
		sessionFactory.getCurrentSession().flush();
		return true;
		
	}

	public boolean update(Category category) {
		sessionFactory.getCurrentSession().update(category);
		return true;
	}

	public boolean delete(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	public Category getByID(String categoryID) {
		
		 return (Category)sessionFactory.getCurrentSession().createQuery("from Category where categoryID='"+categoryID+"'").uniqueResult();
	}

	public Category searchByCategory(String categoryName) {
		
		 return (Category)sessionFactory.getCurrentSession().createQuery("from Category where categoryName like '%"+categoryName+"%'").uniqueResult();
	}

}
