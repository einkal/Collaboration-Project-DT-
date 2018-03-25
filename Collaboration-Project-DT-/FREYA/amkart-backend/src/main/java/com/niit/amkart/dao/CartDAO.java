package com.niit.amkart.dao;

import java.util.List;

import com.niit.amkart.model.Cart;

public interface CartDAO 
{
	public boolean insert(Cart cart);
	public Cart findCartByID(String userMail);
	public Cart getCartByID(int cartID);
	public boolean deleteCart(Cart cart);
	public boolean update(Cart cart);
	
}
