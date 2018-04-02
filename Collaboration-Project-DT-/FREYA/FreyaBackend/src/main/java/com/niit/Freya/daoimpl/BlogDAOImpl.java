package com.niit.Freya.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Freya.dao.BlogDAO;
import com.niit.Freya.model.Blog;
import com.niit.Freya.model.BlogComment;

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
		return (Blog)sessionFactory.getCurrentSession().createQuery("from Blog where blogID="+blogID).uniqueResult();
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

	@Override
	public boolean incrementLikes(Blog blog) {
		System.out.println("increment daoimpl");
		blog.setLikes(blog.getLikes()+1);
		sessionFactory.getCurrentSession().update(blog);
		return true;
	
	}
	@Override

	@Transactional

	public boolean addBlogComment(BlogComment blogComment) {



			sessionFactory.getCurrentSession().save(blogComment);

			return true;

		
	}



	@Override

	@Transactional

	public boolean deleteBlogComment(BlogComment blogComment) {

		

			sessionFactory.getCurrentSession().delete(blogComment);

			return true;

		

	}



	@Override

	@Transactional

	public BlogComment getBlogComment(int commentID) {


			Session session = sessionFactory.openSession();

			return (BlogComment)sessionFactory.getCurrentSession().createQuery("from BlogComment where commentID="+commentID).uniqueResult();



	}



	@Override

	@Transactional

	public List<BlogComment> listBlogComments(int blogID) {

		Session session=sessionFactory.openSession();

		Query query=session.createQuery("from BlogComment where blogID=:blogID");

		query.setParameter("blogID", new Integer(blogID));

		@SuppressWarnings("unchecked")

		List<BlogComment> listBlogComments=query.list();

		return listBlogComments;

	}
}
