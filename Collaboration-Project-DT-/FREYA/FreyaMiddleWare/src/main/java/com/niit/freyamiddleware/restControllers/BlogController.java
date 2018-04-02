package com.niit.freyamiddleware.restControllers;

import org.springframework.web.bind.annotation.RestController;
import com.niit.Freya.dao.BlogDAO;
import com.niit.Freya.model.Blog;
import com.niit.Freya.model.BlogComment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		 List<Blog> listBlogs=blogDAO.list("Travera");
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
	@GetMapping(value="/deleteBlog/{blogID}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogID")int blogID)
	{
		Blog blog=blogDAO.getBlog(blogID);
		if(blogDAO.delete(blog))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	
	}
	@GetMapping(value="/incrementLikes/{blogID}")
	public ResponseEntity<String> incrementLikes(@PathVariable("blogID")int blogID)
	{
		Blog blog=blogDAO.getBlog(blogID);
		if(blogDAO.incrementLikes(blog))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	
	}
	@PutMapping(value = "/updateBlog/{blogID}")

	public ResponseEntity<String> updateBlog(@PathVariable("blogID") int blogID, @RequestBody Blog blog) {

		System.out.println("Updating Blog " + blogID);

		Blog mBlog = blogDAO.getBlog(blogID);

		if (mBlog == null) {

			System.out.println("Blog with blogId " + blogID + " Not Found");

			return new ResponseEntity<String>("Update Blog Failue", HttpStatus.NOT_FOUND);

		}

		
		blogDAO.update(blog);

		return new ResponseEntity<String>("Update Blog Success", HttpStatus.OK);

	}

	
	@GetMapping(value = "/getBlog/{blogID}")

	public ResponseEntity<Blog> getBlog(@PathVariable("blogID") int blogID) {

		System.out.println("Get Blog " + blogID);

		Blog blog = blogDAO.getBlog(blogID);

		if (blog == null) {

			return new ResponseEntity<Blog>(blog, HttpStatus.NOT_FOUND);

		} else {

			return new ResponseEntity<Blog>(blog, HttpStatus.OK);

		}

	}

	
	
	@PutMapping(value = "/approveBlog/{blogID}")

	public ResponseEntity<String> approveBlog(@PathVariable("blogID") int blogID) {

		System.out.println("Approve Blog with Blog ID: " + blogID);

		Blog blog = blogDAO.getBlog(blogID);

		if (blog == null) {

			System.out.println("Not blog with blog Id: " + blogID + " found for Approval");

			return new ResponseEntity<String>("No Blog found for Approval", HttpStatus.NOT_FOUND);

		} else {

			blog.setStatus("A");

			blogDAO.approve(blog);

			return new ResponseEntity<String>("Blog " + blogID + " Approved Successfully", HttpStatus.OK);

		}

	}
	
	
	
	
	
	@PutMapping(value = "/rejectBlog/{blogID}")

	public ResponseEntity<String> rejectBlog(@PathVariable("blogID") int blogID) {

		System.out.println("Disapprove Blog with Blog ID: " + blogID);

		Blog blog = blogDAO.getBlog(blogID);

		if (blog == null) {

			System.out.println("Not blog with blog Id: " + blogID + " found for Approval");

			return new ResponseEntity<String>("No Blog with Blog Id " + blogID + " found for Disapproval",HttpStatus.NOT_FOUND);

		} 
		else {

			blog.setStatus("NA");

			blogDAO.reject(blog);

			return new ResponseEntity<String>("Blog " + blogID + " Disapproved Successfully", HttpStatus.OK);

		}

	}
	
	
	@DeleteMapping(value = "/deleteBlogComment/{commentID}")

	public ResponseEntity<String> deleteBlogComment(@PathVariable("commentID") int commentID) {

		System.out.println("Delete blogComment with comment Id: " + commentID);

		BlogComment blogComment = blogDAO.getBlogComment(commentID);

		if (blogComment == null) {

			System.out.println("No blog " + commentID + " found to delete");

			return new ResponseEntity<String>("No blogcomment with comment Id: " + commentID + " found to delete",

					HttpStatus.NOT_FOUND);

		} else {

			blogDAO.deleteBlogComment(blogComment);

			return new ResponseEntity<String>("BlogComment with comment Id " + commentID + " deleted successfully", HttpStatus.OK);

		}



	}




	@GetMapping(value = "/getBlogComment/{commentID}")

	public ResponseEntity<String> getBlogComment(@PathVariable("commentID") int commentID) {

		System.out.println("Get BlogComment " + commentID);

		BlogComment blogComment = blogDAO.getBlogComment(commentID);

		if (blogComment == null) {

			return new ResponseEntity<String>("Get blogComment failure", HttpStatus.NOT_FOUND);

		} else {

			return new ResponseEntity<String>("Get blogComment Success", HttpStatus.OK);

		}

	}



	

	@GetMapping(value = "/listBlogComments/{blogID}")

	public ResponseEntity<List<BlogComment>> listBlogComments(@PathVariable("blogID")int blogID) {

		System.out.println("In listBlogcomments() method");

		List<BlogComment> listBlogComments = blogDAO.listBlogComments(blogID);

		if (listBlogComments.size() != 0) {

			return new ResponseEntity<List<BlogComment>>(listBlogComments, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<BlogComment>>(listBlogComments, HttpStatus.NOT_FOUND);

		}

	}
}
