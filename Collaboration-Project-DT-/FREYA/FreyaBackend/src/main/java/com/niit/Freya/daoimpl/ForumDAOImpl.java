package com.niit.Freya.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.Freya.dao.BlogDAO;
import com.niit.Freya.dao.ForumDAO;
import com.niit.Freya.model.Blog;
import com.niit.Freya.model.Forum;

public class ForumDAOImpl implements ForumDAO{
	
	@Autowired 
	ForumDAO forumDAO;
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Forum> list() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
	}

	@Override
	public Forum get(int forumID) {
		return (Forum)sessionFactory.getCurrentSession().createQuery("from Forum where forumID='"+forumID+"'").uniqueResult();
	
	}

	@Override
	public boolean save(Forum forum) {
		System.out.println("Saving");
		sessionFactory.getCurrentSession().save(forum);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	@Override
	public boolean update(Forum forum) {
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}

	@Override
	public boolean delete(Forum forum) {
		sessionFactory.getCurrentSession().delete(forum);
		return true;
	}

}
