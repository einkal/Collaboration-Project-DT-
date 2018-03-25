package com.niit.amkart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.amkart.dao.OrdersDAO;
import com.niit.amkart.model.Orders;
import com.niit.amkart.model.Supplier;

@Repository("OrdersDAO")
@Transactional
public class OrdersDAOImpl implements OrdersDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addOrder(Orders orders) {
		sessionFactory.getCurrentSession().save(orders);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	public Orders getOrder(int orderID) {
		return (Orders)sessionFactory.getCurrentSession().createQuery("from Orders where orderId="+orderID).uniqueResult();

	}

	public List<Orders> list(String email) {
		return sessionFactory.getCurrentSession().createQuery("from Orders where userName='"+email+"'").list();

	}

	public boolean update(Orders order) {
		sessionFactory.getCurrentSession().update(order);
		return true;
	}
	

}
