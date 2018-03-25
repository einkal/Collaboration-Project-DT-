package com.niit.amkart.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Orders")
public class Orders implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int orderId;
	
	
	
	@ManyToOne
	@JoinColumn(name="userName")
	private User userName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orderCartID")
	private Cart orderCartID;
	
	private double total;
	
	

	

	
	

	public Cart getOrderCartID() {
		return orderCartID;
	}

	public void setOrderCartID(Cart orderCartID) {
		this.orderCartID = orderCartID;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	private String payment;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	public User getUserName() {
		return userName;
	}

	public void setUserName(User userName) {
		this.userName = userName;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
    
}