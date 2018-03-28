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
@Table(name="APPLYJOB")
@Component
@SequenceGenerator(name="applicationIdSeq",sequenceName="application_id_seq")
public class ApplyJob
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="applicationIdSeq")
    int applicationID;
	String userName;
	Date applyDate;
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

}
