package com.niit.Freya.dao;

import com.niit.Freya.model.Forum;
import com.niit.Freya.model.Job;

public interface JobDAO 
{
	public boolean add(Job job);
public boolean update(Job job);
	
	public boolean delete(Job job);
	

}
