package com.niit.Freya.dao;

import java.util.List;

import com.niit.Freya.model.Forum;
import com.niit.Freya.model.Forum;

public interface ForumDAO
{
public List<Forum> list(String userName);
	
	public Forum getForum(int ForumID);
	
	public boolean add(Forum forum);
	
	public boolean approve(Forum forum);

	public boolean reject(Forum forum);

	public boolean update(Forum forum);
	
	public boolean delete(Forum forum);
	
	
}
