package com.niit.amkart.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.amkart.dao.CategoryDAO;
import com.niit.amkart.dao.ProductDAO;
import com.niit.amkart.dao.SupplierDAO;
import com.niit.amkart.model.Category;
import com.niit.amkart.model.Product;
import com.niit.amkart.model.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value = "/getProduct")
	 public ModelAndView getProductCategory() 
		{
			ModelAndView mv=new ModelAndView("AddEntities");
			System.out.println("inside product");
			List<Product> productList=new ArrayList<Product>(productDAO.list());
			List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			List<Supplier> supplierList=new ArrayList<Supplier>(supplierDAO.list());
			mv.addObject("product",new Product());
			mv.addObject("isProductClicked",true);
			mv.addObject(categoryList);
			mv.addObject(supplierList);
			mv.addObject(productList);
			return mv;
	    }

	
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView submit(HttpServletRequest request, @RequestParam("file")MultipartFile file,@Validated @ModelAttribute("product")Product product,BindingResult result, ModelMap model)throws Exception 
    	{
			ModelAndView modelAndView=new ModelAndView("AddEntities");	
			List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			modelAndView.addObject(categoryList);
			
			System.out.println("Adding image");
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
			List<Product> productList=new ArrayList<Product>(productDAO.list());
			
			String filepath=request.getSession().getServletContext().getRealPath("/");
			String filename=file.getOriginalFilename();
			System.out.println(product.getProductID());
			System.out.println(filepath);
			
    	productDAO.save(product);
    	filename="IMGPRO"+productDAO.get(product.getProductName()).getProductID()+".jpg";
		product.setImageName(filename);
		productDAO.update(product);
        System.out.println("value"+ request.getParameter("categoryID"));
        System.out.println("in submit");
        
        try
        {
        	if (!file.isEmpty())
        	{
	        	byte []imageByte=file.getBytes();
	        	System.out.println("image Size"+imageByte.length);
	        	BufferedOutputStream fileOutputStream=new BufferedOutputStream(new FileOutputStream(filepath+"resources/"+filename));
	        	fileOutputStream.write(imageByte);
       
        	}
        }
             
        
        
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        modelAndView.addObject(productList);
   		model.addAttribute("status","Added Product");
   		model.addAttribute("message","Added Product");
        return modelAndView;
    }


	@RequestMapping(value = "/ModifyProduct")
	 public ModelAndView modifyProduct() 
		{
			ModelAndView mv=new ModelAndView("ModifyProduct");
			
			System.out.println("inside product");
			List<Product> productList=new ArrayList<Product>(productDAO.list());
			mv.addObject(productList);
			return mv;
	    }
	
	
	 @RequestMapping(value="/editProduct/{id}")  
	    public ModelAndView editSupplier(@PathVariable int id)
	    {  
	        Product productEdit=new Product();
	        Product product=new Product();
	        productEdit=productDAO.getByID(id);
	        ModelAndView modelAndView=new ModelAndView("ModifyProduct");
	        List<Product> productList=new ArrayList<Product>(productDAO.list());
	        List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
			List<Supplier> supplierList=new ArrayList<Supplier>(supplierDAO.list());
			modelAndView.addObject("toEdit",true);
			modelAndView.addObject("categoryList",categoryList);
			modelAndView.addObject("supplierList",supplierList);
	        modelAndView.addObject("productList",productList);
	        modelAndView.addObject("product", product);
	        modelAndView.addObject("productEdit", productEdit);
	        return modelAndView;

	    }  
	 
	 

		@RequestMapping(value="editProduct/Save", method = RequestMethod.POST)
	    public ModelAndView saveProduct(@Validated @ModelAttribute("product")Product product,BindingResult result, ModelMap model) 
	    	{
				System.out.println("Editing Product");
				productDAO.update(product);
				List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
				model.addAttribute(categoryList);
				
	        return new ModelAndView("redirect:/ModifyProduct");
	    }

	 
	 
		 @RequestMapping(value="/deleteProduct/{id}")  
		    public ModelAndView deleteSupplier(@PathVariable int id)
		    {
		    	System.out.println("Delete Product");
		    	Product product=new Product();
		    	product=productDAO.getByID(id);
		    	productDAO.delete(product);
		    	
		    	return new ModelAndView("redirect:/ModifyProduct");
		    }
	 
	 
		 @RequestMapping(value="/showAllProducts")  
		    public ModelAndView showAllProducts()
		    {
				System.out.println("category controller");
				List<Product> productList=new ArrayList<Product>(productDAO.list());
		        ModelAndView modelAndView=new ModelAndView("productList");
		        modelAndView.addObject("productList",productList);
       	        List<Category> categoryList=new ArrayList<Category>(categoryDAO.list());
				modelAndView.addObject(categoryList);
				
		    	return modelAndView;
		    	
		    }
	 
	 
	 
	 
	 
	 
	 
	    
	}
