package com.niit.amkart.controllers;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.dao.UserDAO;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Supplier;
import com.niit.amkart.model.User;

@Controller
public class LoginController {
  @Autowired
  UserDAO userDAO;
  @Autowired
	private CategoryDAO categoryDAO;
	
 /*
  @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error)
	 {

	  ModelAndView model = new ModelAndView();
	  
	  model.setViewName("login");

	  return model;

	}
  */
  
  
  @RequestMapping(value = "/goToLogin", method = RequestMethod.GET)
  public ModelAndView showLogin()
  {
	  System.out.println("In goToLogin");
	  ModelAndView modelAndView = new ModelAndView("login");
	  List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
	  return modelAndView;
  }
    
  @RequestMapping("/error")
	
  	public String accessDenied() {
		System.out.println("in error");
		return "error";
  }
  
  @RequestMapping(value ={"/userLogged"},method=RequestMethod.GET)
  public String userLogged(Model model, Principal principal )
  {		
		 System.out.println("user logged");
		 List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			model.addAttribute(categoryList);
			
	       return "redirect:/index";
  }
  
}