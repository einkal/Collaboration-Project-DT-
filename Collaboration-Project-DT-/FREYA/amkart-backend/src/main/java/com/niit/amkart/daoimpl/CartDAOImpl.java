package com.niit.amkart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.amkart.dao.CartDAO;
import com.niit.amkart.model.Cart;

import com.niit.amkart.model.Product;
@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean insert(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);
		sessionFactory.getCurrentSession().flush();
		return true;

		
	}

	public Cart findCartByID(String userMail) {
		// TODO Auto-generated method stub
		return (Cart)sessionFactory.getCurrentSession().createQuery("from Cart where useremail='"+userMail+"'").uniqueResult();
	}

	public Cart getCartByID(int cartID) {
		// TODO Auto-generated method stub
		 return (Cart)sessionFactory.getCurrentSession().createQuery("from Cart where cartID="+cartID).uniqueResult();
	}

	public boolean deleteCart(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
		return true;		
	}

	public boolean update(Cart cart) {
			sessionFactory.getCurrentSession().update(cart);
		return true;		
	}

}
