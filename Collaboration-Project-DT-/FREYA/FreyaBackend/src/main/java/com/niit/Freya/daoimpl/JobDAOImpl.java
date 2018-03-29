package com.niit.Freya.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Freya.dao.BlogDAO;
import com.niit.Freya.dao.JobDAO;
import com.niit.Freya.model.ApplyJob;
import com.niit.Freya.model.Blog;
import com.niit.Freya.model.Job;
@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO{

	@Autowired 
	JobDAO jobDAO;
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")

	@Override
	public boolean addJob(Job job) {
		System.out.println("Saving");
		sessionFactory.getCurrentSession().save(job);
		sessionFactory.getCurrentSession().flush();
		return true;
	
	}

	@Override
	public boolean deleteJob(Job job) {
		sessionFactory.getCurrentSession().delete(job);
		return true;
	}

	@Override
	public boolean updateJob(Job job) {
		sessionFactory.getCurrentSession().update(job);
		return true;
	}

	@Override
	public List<Job> listAllJobs() {
		return sessionFactory.getCurrentSession().createQuery("from Job").list();

	}

	@Override
	public boolean applyJob(ApplyJob applyJob) 
	{
		sessionFactory.getCurrentSession().save(applyJob);
		return true;
	}
	@Override
	public List<ApplyJob> getAllAppliedJobDetails(String userName) {
		return sessionFactory.getCurrentSession().createQuery("from ApplyJob where username='"+userName+"'").list();

	}

	@Override
	public Job getJob(int jobID) {
		return (Job)sessionFactory.getCurrentSession().createQuery("from Job where jobID="+jobID).uniqueResult();
	}

}
