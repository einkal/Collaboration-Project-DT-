package com.niit.amkart.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CartDAO;
import com.niit.amkart.dao.CartItemDAO;
import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.dao.ProductDAO;
import com.niit.amkart.dao.UserDAO;
import com.niit.amkart.model.Cart;
import com.niit.amkart.model.CartItem;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Product;
import com.niit.amkart.model.Supplier;
import com.niit.amkart.model.User;

@Controller
public class CartItemController {
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

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public ModelAndView addCartItem(@Validated @ModelAttribute("cartItem")CartItem cartItem,@RequestParam("productID")int productID,BindingResult result, ModelMap model)
	{
		boolean flag=false;
		String email = (SecurityContextHolder.getContext().getAuthentication().getName());
		User user = new User();
		String role=" ";
		
		if(email=="anonymousUser")
		{
		
			 ModelAndView modelAndView = new ModelAndView("registration");
			 modelAndView.addObject("user",user);
			 return modelAndView;
		}
		ModelAndView modelAndView=new ModelAndView("Cart");
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		if(result.hasErrors())
		 {
	        String message = "Adding Unsuccessful!!Errors:";
  		for (Object object : result.getAllErrors()) 
  		{
  		    if(object instanceof FieldError) {
  		        FieldError fieldError = (FieldError) object;
  		        message+=fieldError.getField()+":"+fieldError.getDefaultMessage()+"!    ";
  		    }
  		}
  		modelAndView.addObject("message", message);
  		model.addAttribute("status",message);
  		return modelAndView;
		 }
		user = userDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());
		String emailID = user.getEmail();
		Cart cart = (Cart)cartDAO.findCartByID(emailID);
		double price=0;
		int quantity=0;
		Product product=productDAO.getByID(productID);
		product.setStock(product.getStock()-cartItem.getQuantity());
		List<CartItem> cartItems = cart.getCartItem();
		System.out.println("qty"+cartItem.getQuantity());
		
			for (int i = 0; i < cartItems.size(); i++) {
				CartItem item = cartItems.get(i);
				if (product.getProductID()==(item.getProduct().getProductID()))
				{
					item.setQuantity(item.getQuantity() + cartItem.getQuantity());
					item.setPrice(item.getQuantity() * item.getProduct().getPrice());
					cartItemDAO.updateCartItem(item);
					flag=true;
					break;		
				}
			}
		
		
		if(flag==false)
		{	
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItemDAO.addCartItem(cartItem);
		cartItem.setPrice(product.getPrice()*cartItem.getQuantity());
		cartItemDAO.updateCartItem(cartItem);
		cartItems.add(cartItem);
		cart.setCartItem(cartItems);
		}
		cartItems = cart.getCartItem();
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
		modelAndView.addObject("message","Added Successfully");
  		model.addAttribute("status","Added Successfully");
  				return modelAndView;
	}










}
