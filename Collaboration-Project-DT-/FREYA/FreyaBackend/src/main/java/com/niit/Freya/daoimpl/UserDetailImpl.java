package com.niit.Freya.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Freya.dao.BlogDAO;
import com.niit.Freya.dao.UserDetailDAO;
import com.niit.Freya.model.Blog;
import com.niit.Freya.model.UserDetail;
@Repository("userDetailDAO")
@Transactional
public class UserDetailImpl implements UserDetailDAO{
	@Autowired 
	UserDetailDAO userDetailDAO;
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	
	@Override
	public boolean registerUser(UserDetail userDetail)
	{
		System.out.println("Saving");
		sessionFactory.getCurrentSession().save(userDetail);
		sessionFactory.getCurrentSession().flush();
		return true;
	
	}

	@Override
	public boolean deleteUserDetail(UserDetail userDetail) 
	{
		sessionFactory.getCurrentSession().delete(userDetail);
		return true;
	
	}

	@Override
	public boolean updateUserDetail(UserDetail userDetail) {
		sessionFactory.getCurrentSession().update(userDetail);
		return true;

	}

	@Override
	public UserDetail getUserDetail(String userName) 
	{
		return (UserDetail)sessionFactory.getCurrentSession().createQuery("from UserDetail where userName='"+userName+"'").uniqueResult();
	}

	@Override
	public List<UserDetail> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from UserDetail").list();
	}

	@Override
	public boolean checkLogin(UserDetail userDetail) {
		
		Query query=(Query) sessionFactory.getCurrentSession().createQuery("from UserDetail where userName='"+userDetail.getUserName()+"' and password='"+userDetail.getPassword()+"'").uniqueResult();
		UserDetail userDetail1=(UserDetail)query.list().get(0);
		if(userDetail1==null)
			return false;
		else
			return true;
	}

	@Override
	public boolean updateOnlineStatus(String status, UserDetail userDetail)
	{
		userDetail.setIsOnline(status);
		sessionFactory.getCurrentSession().update(userDetail);
		return true;
	}

}
