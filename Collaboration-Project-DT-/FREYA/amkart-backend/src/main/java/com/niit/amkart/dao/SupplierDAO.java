
package com.niit.amkart.dao;
import java.util.List;
import com.niit.amkart.model.Supplier;


public interface SupplierDAO{
	public List<Supplier> list();
	
	public Supplier get(String supplierName);
	public Supplier getByID(String supplierID);
	public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public boolean delete(Supplier supplier);

}
