package com.niit.amkart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.amkart.dao.CartDAO;
import com.niit.amkart.dao.UserDAO;
import com.niit.amkart.model.Cart;
import com.niit.amkart.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired 
	CartDAO cartDAO;
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<User> list() {
		
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User get(String email) {
		
		return (User)sessionFactory.getCurrentSession().createQuery("from User where email='"+email+"'").uniqueResult();
	}

	public boolean save(User user) {
		Cart cart=new Cart();
		sessionFactory.getCurrentSession().save(cart);
		user.setCart(cart);
		sessionFactory.getCurrentSession().save(user);
		cart.setCartUserDetails(user);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	public boolean update(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	public boolean delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	

}
