package com.niit.Freya.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="JOB")
@Component
@SequenceGenerator(name="jobIdSeq",sequenceName="job_id_seq")
public class Job
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="jobIdSeq")
    int jobID;
 	String jobDesignation;
    String company;
    int salary;
    String location;
    String jobDesc;
    Date lastDateApply;	
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobId) {
		this.jobID = jobId;
	}
	public String getJobDesignation() {
		return jobDesignation;
	}
	public void setJobDesignation(String jobDesignation) {
		this.jobDesignation = jobDesignation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public Date getLastDateApply() {
		return lastDateApply;
	}
	public void setLastDateApply(Date lastDateApply) {
		this.lastDateApply = lastDateApply;
	}
	
}
