package com.niit.amkart.dao;

import java.util.List;

import com.niit.amkart.model.Orders;
import com.niit.amkart.model.User;

public interface OrdersDAO {
	boolean addOrder(Orders orders);
	Orders getOrder(int orderID);
	public List<Orders> list(String email);
	public boolean update(Orders order);
	}


