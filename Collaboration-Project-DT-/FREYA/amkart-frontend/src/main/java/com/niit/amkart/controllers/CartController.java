package com.niit.amkart.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CartDAO;
import com.niit.amkart.dao.CartItemDAO;
import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.dao.OrdersDAO;
import com.niit.amkart.dao.ProductDAO;
import com.niit.amkart.dao.UserDAO;
import com.niit.amkart.model.Cart;
import com.niit.amkart.model.CartItem;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Orders;
import com.niit.amkart.model.User;

@Controller
public class CartController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private UserDAO userDAO;	
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private OrdersDAO ordersDAO;	 
	@RequestMapping("/removeItem/{cartItemId}")
		public ModelAndView removeCartItem(@PathVariable int cartItemId)
	{
		ModelAndView modelAndView=new ModelAndView("Cart");
		System.out.println("in remv cntrlr");
		CartItem cartItem=new CartItem();
		cartItem=cartItemDAO.getCartItemByID(cartItemId);
		System.out.println("Cntrlr :"+cartItem.getCartItemID());
		cartItemDAO.removeCartItem(cartItem);
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		return getCartItems(modelAndView);
	}

	@RequestMapping("/removeAllItems/{cartId}")
		public  ModelAndView removeAllCartItems(@PathVariable int cartId) {
		System.out.println("Remove all items");
		ModelAndView modelAndView=new ModelAndView("Cart");
		Cart cart = cartDAO.getCartByID(cartId);
		cartItemDAO.removeAllCartItems(cart);
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		
		return getCartItems(modelAndView);
	}
	
	
	@RequestMapping("/getCart")
	public  ModelAndView getCart()
	{
		ModelAndView modelAndView=new ModelAndView("Cart");
		return getCartItems(modelAndView);
	}
	@RequestMapping("/checkOut/{cartId}")
	public  ModelAndView checkOut(@PathVariable int cartId)
	{
		ModelAndView modelAndView=new ModelAndView("CheckOut");
		Orders orders=new Orders();
		Cart cart=new Cart();
		User user = userDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());
		cart=cartDAO.getCartByID(cartId);
		orders.setOrderCartID(cart);
		orders.setTotal(cart.getCartPrice());
		orders.setUserName(user);
		ordersDAO.addOrder(orders);
		Orders orderdetails=ordersDAO.getOrder(orders.getOrderId());
		modelAndView.addObject("order",orderdetails);
		modelAndView.addObject("cart",cart);
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		
		return modelAndView;
	}
	public ModelAndView getCartItems(ModelAndView modelAndView)
	{
		
		User user = userDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());
		String emailID = user.getEmail();
		Cart cart = new Cart();
		cart = (Cart)cartDAO.findCartByID(emailID);
		double price=0;
		int quantity=0;
		List<CartItem> cartItems = cart.getCartItem();
		for(CartItem item: cartItems){
			price += item.getPrice();
			quantity+=item.getQuantity();
		}
		cart.setCartPrice(price);
		cart.setCartQuantity(quantity);
		cartDAO.update(cart);
		cartItems = cart.getCartItem();
		modelAndView.addObject("cartItems", cartItems);
		modelAndView.addObject("cartPrice",price);
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		
		return modelAndView;
		
	}

}
