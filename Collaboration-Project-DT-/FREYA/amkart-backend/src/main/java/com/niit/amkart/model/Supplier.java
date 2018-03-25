package com.niit.amkart.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Entity
@Table(name="SUPPLIER")
@Component
public class Supplier {
	@Id
	@NotNull
	 @Pattern(regexp="^[Ss][0-9]{3}$", message="Should start with S")
	@Length(max=4,min=4, message ="Length should be 4")
	private String supplierID;
	
	private String supplierName;
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER, mappedBy="supplier")
	private Set<Product> products=new HashSet<Product>(0);
	
	public Set<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public String getsupplierName() {
		return supplierName;
	}
	public void setsupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	

}
