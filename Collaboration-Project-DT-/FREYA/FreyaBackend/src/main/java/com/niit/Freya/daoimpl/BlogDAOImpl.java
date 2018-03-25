package com.niit.Freya.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Freya.dao.BlogDAO;
import com.niit.Freya.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired 
	BlogDAO blogDAO;
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<Blog> list(String userName) {
		return sessionFactory.getCurrentSession().createQuery("from Blog where username='"+userName+"'").list();
		
	}

	public Blog getBlog(int blogID) {
		return (Blog)sessionFactory.getCurrentSession().createQuery("from User where blogID="+blogID).uniqueResult();
	}

	public boolean add(Blog blog) {
		System.out.println("Saving");
		sessionFactory.getCurrentSession().save(blog);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	public boolean update(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}

	public boolean delete(Blog blog) {
		sessionFactory.getCurrentSession().delete(blog);
		return true;
	}

	@Override
	public boolean approve(Blog blog) {
		blog.setStatus("A");
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}

	@Override
	public boolean reject(Blog blog) {
		blog.setStatus("A");
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}

}
