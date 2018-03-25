package com.niit.amkart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.amkart.dao.CartDAO;
import com.niit.amkart.dao.CartItemDAO;
import com.niit.amkart.model.Cart;
import com.niit.amkart.model.CartItem;

@Repository("CartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private CartDAO cartDAO;
	public boolean addCartItem(CartItem cartItem)
	{
		sessionFactory.getCurrentSession().save(cartItem);
		sessionFactory.getCurrentSession().flush();
		return true;
		
	}

	public boolean removeCartItem(CartItem cartItem)
	{
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		Cart cart = cartItem.getCart();
		List<CartItem> cartItems = cart.getCartItem();
		cartItems.remove(cartItem);
		cart.setCartItem(cartItems);
		cartDAO.update(cart);
		session.flush();	
		return true;
	}

	public boolean removeAllCartItems(Cart cart) 
	{
		
		List<CartItem> cartItems = cart.getCartItem();
		for (int i = 0; i < cartItems.size(); i++) 
		{
			CartItem item = cartItems.get(i);
			sessionFactory.getCurrentSession().delete(item);
		}
			cartItems.clear();
			cart.setCartItem(cartItems);
			cartDAO.update(cart);
		return true;
		
		
	}

	public boolean updateCartItem(CartItem cartItem) {
		sessionFactory.getCurrentSession().update(cartItem);
		return true;
		}

	public CartItem getCartItemByID(int cartItemID) {
		 return (CartItem)sessionFactory.getCurrentSession().createQuery("from CartItem where cartItemID="+cartItemID).uniqueResult();

	}

	
	
	}
