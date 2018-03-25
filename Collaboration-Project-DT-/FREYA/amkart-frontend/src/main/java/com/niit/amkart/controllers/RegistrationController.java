package com.niit.amkart.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CartDAO;
import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.dao.SupplierDAO;
import com.niit.amkart.dao.UserDAO;
import com.niit.amkart.model.Cart;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Supplier;
import com.niit.amkart.model.User;
@Controller
public class RegistrationController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	 @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegistration()
	  {
	    
		 User user=new User();
		 ModelAndView modelAndView = new ModelAndView("registration");
		 modelAndView.addObject("user",user);
		 List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			modelAndView.addObject(categoryList);
			
		 return modelAndView;
	  }
	 @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	  public ModelAndView confirmRegistration(@Validated @ModelAttribute("user")User user, 
		      BindingResult result, ModelMap model)
	  {
	    
		 if(result.hasErrors())
		 {
			 return (new ModelAndView("registration"));
		 }
		 userDAO.save(user);
		 user.setEnabled(true);
		 user.setRole("USER");
		 String encoded=new BCryptPasswordEncoder().encode(user.getPassword());
		 user.setPassword(encoded);
		 userDAO.update(user);
		 ModelAndView modelAndView = new ModelAndView("login");
		 String message="You are successfully registered. Login now..";
		 modelAndView.addObject("message",message);
		 List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		 return modelAndView;
	  }
	 
}
