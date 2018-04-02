package com.niit.Freya.dao;

import java.util.List;

import com.niit.Freya.model.Blog;
import com.niit.Freya.model.BlogComment;


public interface BlogDAO
{
public List<Blog> list(String userName);
	
	public Blog getBlog(int BlogID);
	
	public boolean add(Blog blog);
	
	public boolean approve(Blog blog);

	public boolean reject(Blog blog);

	public boolean update(Blog blog);
	
	public boolean delete(Blog blog);
	public boolean incrementLikes(Blog blog);

	boolean addBlogComment(BlogComment blogComment);

	boolean deleteBlogComment(BlogComment blogComment);

	BlogComment getBlogComment(int commentId);

	List<BlogComment> listBlogComments(int blogID);

}
