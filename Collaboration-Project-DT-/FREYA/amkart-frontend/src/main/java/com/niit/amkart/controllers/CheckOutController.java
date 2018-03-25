package com.niit.amkart.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.niit.amkart.model.Product;
import com.niit.amkart.model.User;

@Controller
public class CheckOutController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private OrdersDAO orderDAO;		
	@Autowired
	private UserDAO userDAO;	
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/placeOrder/{orderID}/{cartID}")
	public  ModelAndView placeOrder(@PathVariable int orderID,@PathVariable int cartID)
	{
		
		User user = userDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(cartID);
		Orders order=new Orders();
		order=orderDAO.getOrder(orderID);
		Cart cart = cartDAO.getCartByID(cartID);
		List<CartItem> cartItems = cart.getCartItem();
		Product product=new Product();
		for (int i = 0; i < cartItems.size(); i++)
		{
				CartItem item = cartItems.get(i);
				product=productDAO.getByID(item.getProduct().getProductID());
				product.setStock(product.getStock()-item.getQuantity());
				productDAO.update(product);
		}
		cartItemDAO.removeAllCartItems(cart);	
		Set<Orders> orders=new HashSet<Orders>();
		orders.add(order);
		ModelAndView modelAndView=new ModelAndView("OrderPlacedDetails");
		order.setPayment("done");
		orderDAO.update(order);
		user.setOrder(orders);
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		modelAndView.addObject("message","Your order is placed successfully.. Thank You..");
		return modelAndView;
	}
}
