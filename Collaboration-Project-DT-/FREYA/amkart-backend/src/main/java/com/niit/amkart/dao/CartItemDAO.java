package com.niit.amkart.dao;

import com.niit.amkart.model.Cart;
import com.niit.amkart.model.CartItem;

public interface CartItemDAO {

	boolean addCartItem(CartItem cartItem);
	boolean updateCartItem(CartItem cartItem);
	public CartItem getCartItemByID(int cartItemID);
	boolean removeCartItem(CartItem cartItem);
	boolean removeAllCartItems(Cart cart);
}
