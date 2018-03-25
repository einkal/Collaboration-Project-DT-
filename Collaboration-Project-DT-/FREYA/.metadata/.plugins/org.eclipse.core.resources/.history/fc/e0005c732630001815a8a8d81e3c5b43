package com.niit.freyamiddleware.restControllers;

import org.springframework.web.bind.annotation.RestController;

import com.niit.Freya.dao.BlogDAO;
import com.niit.Freya.model.Blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BlogController {
	@Autowired
	BlogDAO blogDAO;
	
	@GetMapping(value="/demo")
	public ResponseEntity<String> demoPurpose()
{
	return new ResponseEntity<String>("Demo Data",HttpStatus.OK);
		
}
	
	@GetMapping(value="/listBlogs")
	public ResponseEntity<List<Blog>> getListBlogs(){
		 List<Blog> listBlogs=blogDAO.list("Amrita");
		 return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
		
	}
	@PostMapping(value="/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setUserName("Travera");
		blog.setStatus("A");
		if(blogDAO.add(blog))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}

}
