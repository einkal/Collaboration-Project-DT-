package com.niit.amkart.controllers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.dao.SupplierDAO;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Supplier;


@Controller
public class SupplierController 
{
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	
	
	@RequestMapping(value = "/getSupplier")
	 public ModelAndView getSupplierCategory() 
		{
			ModelAndView modelAndView=new ModelAndView("AddEntities");
			List<Supplier> supplierList=new ArrayList<Supplier>(supplierDAO.list());
			System.out.println("inside supplier");
			modelAndView.addObject("supplier",new Supplier());
			modelAndView.addObject("isSupplierClicked",true);
			List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			modelAndView.addObject(categoryList);
		
			modelAndView.addObject(supplierList);
	      	return modelAndView;
	    }
	
	
    @RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
    public ModelAndView submit(@Validated @ModelAttribute("supplier")Supplier supplier, 
      BindingResult result, ModelMap model) 
    {
	    ModelAndView modelAndView=new ModelAndView("AddEntities");
		List<Supplier> supplierList=new ArrayList<Supplier>(supplierDAO.list());
		List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
		modelAndView.addObject(categoryList);
	
		if(result.hasErrors())
		 {
	        String message = "Adding Unsuccessful!!Errors:";
	        for (Object object : result.getAllErrors()) 
	        {
	        	if(object instanceof FieldError) 
	        	{
	   		        FieldError fieldError = (FieldError) object;
	   		        message+=fieldError.getField()+":"+fieldError.getDefaultMessage()+"!    ";
	        	}
	        }
	   		modelAndView.addObject("message", message);
	   		model.addAttribute("status",message);
	   		return modelAndView;
		}
        modelAndView.addObject("message", "Added Successfully..");
        supplierDAO.save(supplier);
        System.out.println("in submit");
        modelAndView.addObject("status","Added Successfully");
        return modelAndView;
    }
    
    @RequestMapping(value = "/ModifySupplier")
	 public ModelAndView modifySupplier() 
		{
			ModelAndView modelAndView=new ModelAndView("ModifySupplier");
			List<Supplier> supplierList=new ArrayList<Supplier>(supplierDAO.list());
			System.out.println("inside supplier");
			modelAndView.addObject("supplierList",supplierList);
			List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			modelAndView.addObject(categoryList);
		
	      	return modelAndView;
	    }
    
	    @RequestMapping(value="/editSupplier/{id}")  
	    public ModelAndView editSupplier(@PathVariable String id)
	    {  
	        Supplier supplierEdit=new Supplier();
	        Supplier supplier=new Supplier();
	        supplierEdit=supplierDAO.getByID(id);
	        List<Supplier> supplierList=new ArrayList<Supplier>(supplierDAO.list());
	        ModelAndView modelAndView=new ModelAndView("ModifySupplier");
	        modelAndView.addObject("toEdit",true);
	        modelAndView.addObject("supplierList",supplierList);
	        modelAndView.addObject("supplier", supplier);
	        modelAndView.addObject("supplierEdit", supplierEdit);
	        List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			modelAndView.addObject(categoryList);
		
	        return modelAndView;

	    }  
	    
	    
	    
	   
	    @RequestMapping(value="/editSupplier/Save")  
	    public ModelAndView SaveSupplier(@ModelAttribute("supplier")Supplier supplier,BindingResult result, ModelMap model)
	    {  
	        System.out.println("In confirm");
	    	supplierDAO.update(supplier);
	    	return new ModelAndView("redirect:/ModifySupplier");
	    	
	    }
	    @RequestMapping(value="/deleteSupplier/{id}")  
	    public ModelAndView deleteSupplier(@PathVariable String id)
	    {
	    	System.out.println("Delete Supplier");
	    	Supplier supplier=new Supplier();
	    	supplier=supplierDAO.getByID(id);
	    	supplierDAO.delete(supplier);
	    	return new ModelAndView("redirect:/ModifySupplier");
	    }
}
