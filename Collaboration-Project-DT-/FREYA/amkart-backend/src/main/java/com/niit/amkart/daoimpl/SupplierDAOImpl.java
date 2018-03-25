package com.niit.amkart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.amkart.dao.SupplierDAO;
import com.niit.amkart.model.Supplier;


@Repository("SupplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public List<Supplier> list() 
	{
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();

	}

	public Supplier get(String supplierName) {
		return (Supplier)sessionFactory.getCurrentSession().createQuery("from Supplier where supplierName='"+supplierName+"'").uniqueResult();
		
	}

	public boolean save(Supplier supplier) {
		System.out.println("Saving");
		sessionFactory.getCurrentSession().save(supplier);
		sessionFactory.getCurrentSession().flush();
		return true;
	}

	public boolean update(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
		return true;
		
	}

	public boolean delete(Supplier supplier) {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	public Supplier getByID(String supplierID) {
		// TODO Auto-generated method stub
		 return (Supplier)sessionFactory.getCurrentSession().createQuery("from Supplier where supplierID='"+supplierID+"'").uniqueResult();

	}
}
