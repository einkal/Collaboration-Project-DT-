package com.niit.amkart.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.dao.ProductDAO;
import com.niit.amkart.dao.SupplierDAO;
import com.niit.amkart.model.Cart;
import com.niit.amkart.model.CartItem;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Product;
import com.niit.amkart.model.Supplier;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping(value = "/getCategory")
	 public ModelAndView getSupplierCategory() 
		{
			ModelAndView modelAndView=new ModelAndView("AddEntities");
			List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			System.out.println("inside category");
			modelAndView.addObject("category",new Category());
			modelAndView.addObject("isCategoryClicked",true);
			modelAndView.addObject(categoryList);
	      	return modelAndView;
	    }
		

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public ModelAndView submit(@Validated @ModelAttribute("category")Category category, 
      BindingResult result, ModelMap model) 
    	{
    		
    	ModelAndView modelAndView=new ModelAndView("AddEntities");
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
        categoryDAO.save(category);
        System.out.println("in submit");
        modelAndView.addObject("message", "Added Successfully..");
        modelAndView.addObject("status", "Added Successfully..");

        return modelAndView;
    }
    
    @RequestMapping(value="/showCategory/{id}")  
    public ModelAndView showCategory(@PathVariable String id)
    {
		System.out.println("category controller");
    	Category category= new Category();
		category=categoryDAO.getByID(id);
		List<Product> productList=new ArrayList<Product>(category.getProducts());
        ModelAndView modelAndView=new ModelAndView("ListProduct");
        modelAndView.addObject("productList",productList);
        modelAndView.addObject("categoryName", category.getCategoryName());
        
        List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		
    	return modelAndView;
    	
    }
   
    
    @RequestMapping("/ListProduct")
	public ModelAndView showProductPage(Model model)
	{
        ModelAndView modelAndView=new ModelAndView("ListProduct");
        List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		
		return  modelAndView;
	}

    @RequestMapping(value="/displayProduct/{id}")  
    public ModelAndView displayProduct(@PathVariable int id)
    {
        ModelAndView modelAndView=new ModelAndView("DisplayProduct");
        Cart cart=new Cart();
        CartItem cartItem=new CartItem();
    	Product product= new Product();
		product=productDAO.getByID(id);
        modelAndView.addObject("cartItem",cartItem);
        List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		modelAndView.addObject("product", product);
		return modelAndView;
    	
    }
    
    
    @RequestMapping(value="/searchCategory")  
    public ModelAndView searchCategory(HttpServletRequest request)
    {
		System.out.println("category controller");
    	Category category= new Category();
    	String searchCategory=request.getParameter("search");
    	if(searchCategory.equals(" ")|| searchCategory==null)
    	{
    		ModelAndView modelAndView = new ModelAndView("index");
    		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
    		modelAndView.addObject(categoryList);
    		return modelAndView;
    	}
    	category=categoryDAO.searchByCategory(searchCategory);
		List<Product> productList=new ArrayList<Product>(category.getProducts());
        ModelAndView modelAndView=new ModelAndView("ListProduct");
        modelAndView.addObject("productList",productList);
        modelAndView.addObject("categoryName", category.getCategoryName());
        List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
		
    	return modelAndView;
    
    }
    
    
}
