package com.niit.Freya.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Freya.dao.ProfileUpdateDAO;
import com.niit.Freya.model.ProfilePicture;
@Repository("profileUpdateDAO")
@Transactional
public class ProfileUpdateDAOImpl implements ProfileUpdateDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(ProfilePicture profilePicture) {
		System.out.println("Saving");
		sessionFactory.getCurrentSession().save(profilePicture);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	@Override
	public ProfilePicture getProfilePicture(String userName) {
		return (ProfilePicture)sessionFactory.getCurrentSession().get(ProfilePicture.class,userName);	
	}

}
