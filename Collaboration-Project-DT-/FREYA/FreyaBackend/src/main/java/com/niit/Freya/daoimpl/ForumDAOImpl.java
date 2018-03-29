package com.niit.Freya.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Freya.dao.ForumDAO;
import com.niit.Freya.dao.ForumDAO;
import com.niit.Freya.model.Blog;
import com.niit.Freya.model.Forum;
import com.niit.Freya.model.ForumComment;
import com.niit.Freya.model.Forum;
@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO{
	
	@Autowired 
	ForumDAO forumDAO;
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Forum> list(String userName) {
		return sessionFactory.getCurrentSession().createQuery("from Forum where username='"+userName+"'").list();
		
	}

	public Forum getForum(int forumID) {
		return (Forum)sessionFactory.getCurrentSession().createQuery("from Forum where forumID="+forumID).uniqueResult();
	}

	public boolean add(Forum forum) {
		System.out.println("Saving");
		sessionFactory.getCurrentSession().save(forum);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	public boolean update(Forum forum) {
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}

	public boolean delete(Forum forum) {
		sessionFactory.getCurrentSession().delete(forum);
		return true;
	}

	@Override
	public boolean approve(Forum forum) {
		forum.setStatus("A");
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}

	@Override
	public boolean reject(Forum forum)
	{
		forum.setStatus("A");
		sessionFactory.getCurrentSession().update(forum);
		return true;
	}

	@Override
	public boolean addForumComment(ForumComment forumComment) {
		sessionFactory.getCurrentSession().save(forumComment);		
		return true;
	}

	@Override
	public boolean deleteForumComment(ForumComment forumComment) {
		sessionFactory.getCurrentSession().delete(forumComment);		
		return true;
	}

	@Override
	public ForumComment getForumComment(int commentID) {
		return (ForumComment)sessionFactory.getCurrentSession().createQuery("from ForumComment where commentID="+commentID).uniqueResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ForumComment> listForumComments(int forumID) {
		return sessionFactory.getCurrentSession().createQuery("from ForumComment where forumID='"+forumID+"'").list();
	}

	
	}
