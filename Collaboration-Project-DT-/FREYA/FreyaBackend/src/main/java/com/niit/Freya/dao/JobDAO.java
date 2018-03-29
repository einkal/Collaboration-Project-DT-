package com.niit.Freya.dao;

import java.util.List;

import com.niit.Freya.model.ApplyJob;
import com.niit.Freya.model.Forum;
import com.niit.Freya.model.Job;

public interface JobDAO 
{
	 	public boolean addJob(Job job);
	    public boolean deleteJob(Job job);
	    public boolean updateJob(Job job);
	    public Job getJob(int jobID);  
	    public List<Job> listAllJobs();
	    public boolean applyJob(ApplyJob applyJob);
	    public List<ApplyJob> getAllAppliedJobDetails(String userName);
}
