package com.niit.Freya.dao;

import java.util.List;

import com.niit.Freya.model.Blog;
import com.niit.Freya.model.Forum;

public interface ForumDAO
{
public List<Forum> list();
	
	public Forum get(int forumID);
	
	public boolean save(Forum forum);
	
	public boolean update(Forum forum);
	
	public boolean delete(Forum forum);
	
	
	
	
	
}
