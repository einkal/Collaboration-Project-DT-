package com.niit.amkart.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.model.Category;

@Controller
public class AdminAddController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = "/AddEntities", method = RequestMethod.GET)
	 public ModelAndView showForm(ModelMap model) 
	{
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		model.addAttribute("categoryList", categoryList);
		return (new ModelAndView("AddEntities"));
    }
   
	
	
}

