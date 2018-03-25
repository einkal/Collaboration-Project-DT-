package com.niit.amkart.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.model.Category;

@ControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	private CategoryDAO categoryDAO;
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {
		
		ModelAndView modelAndView = new ModelAndView("error");
		
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		modelAndView.addObject("name", e.getClass().getSimpleName());
		modelAndView.addObject("message", e.getMessage());

		return modelAndView;
	}
}