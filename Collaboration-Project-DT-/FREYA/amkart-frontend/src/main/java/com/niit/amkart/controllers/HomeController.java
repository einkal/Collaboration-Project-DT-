package com.niit.amkart.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.dao.OrdersDAO;
import com.niit.amkart.dao.UserDAO;
import com.niit.amkart.model.Cart;
import com.niit.amkart.model.CartItem;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Orders;
import com.niit.amkart.model.User;

@Controller
public class HomeController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private OrdersDAO ordersDAO;
	@GetMapping("/")
	public ModelAndView showMessage() 
	{
		ModelAndView modelAndView = new ModelAndView("index");
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		
		System.out.println("In controller");
		return modelAndView;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
	@RequestMapping(value = "/ContactUs", method = RequestMethod.GET)
    public ModelAndView contactPage() {
		  ModelAndView modelAndView=new ModelAndView("ContactUs");

		  List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			modelAndView.addObject("categoryList", categoryList);
		return modelAndView;
    }
 
	@RequestMapping("/index")
	public String showHomePage(Model model)
	{
		String email = (SecurityContextHolder.getContext().getAuthentication().getName());
		User user = null;
		String role=" ";
		if(email!="anonymousUser")
			user=userDAO.get(email);
		
		if(user!=null)
		role=user.getRole();
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		model.addAttribute("categoryList", categoryList);
		if(role.equals("ADMIN") || role.equals("USER"))
		model.addAttribute("role",role);
		else
			model.addAttribute("role",role);
	

		System.out.println(role);
		return  "redirect:/";
	}

	
	  @RequestMapping(value="/logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        
	        request.getSession().invalidate();
	        return "redirect:/login?logout";
	    }
	
	  @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			model.addAttribute("categoryList",categoryList);
			
	        return "accessDenied";
	    }
	  private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof User) {
	            userName = ((User)principal).getName();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
	  
	  
	  @RequestMapping("/showOrderDetails")
	  public ModelAndView showOrderDetails(ModelMap model) 
	  {
	      	 
		  ModelAndView modelAndView=new ModelAndView("OrderDetails");
			User user = userDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());
			String emailID = user.getEmail();
			List orders= ordersDAO.list(emailID);
			System.out.println("id:"+emailID);
			for(int i=0;i<orders.size();i++)
			{
				Orders order=(Orders) orders.get(i);
				System.out.println(order.getOrderId());
			}
				modelAndView.addObject("orderList",orders);
				List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
				model.addAttribute("categoryList", categoryList);
			return modelAndView;
	  }
	  
	  
	  @RequestMapping("/showUserDetails")
		public ModelAndView showUserDetails() 
		{
			ModelAndView modelAndView = new ModelAndView("UserDetails");
			User user = userDAO.get(SecurityContextHolder.getContext().getAuthentication().getName());
			modelAndView.addObject("user",user);
			List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			modelAndView.addObject("categoryList", categoryList);
			System.out.println("In controller");
			return modelAndView;
		}
	  
	  
	 }

