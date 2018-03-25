package com.niit.amkart;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.amkart.config.AppContextConfig;
import com.niit.amkart.dao.SupplierDAO;
import com.niit.amkart.model.Supplier;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppContextConfig.class)
public class SupplierTest
{
	@Autowired
	public Supplier supplier;
	
	@Autowired
	public SupplierDAO supplierDAO;
	
	@Test
	public void testCreateSupplier() {
		System.out.println("testing create");
		supplier.setSupplierID("S00003");
		supplier.setsupplierName("Ramen");
		assertEquals(true, supplierDAO.save(supplier));
	}
	
	@Test
	public void testUpdateSupplier() {
		System.out.println("testing update");
		supplier.setSupplierID("S00001");
		supplier.setsupplierName("Joe");
		assertEquals(true, supplierDAO.update(supplier));
		
	}
	
}
