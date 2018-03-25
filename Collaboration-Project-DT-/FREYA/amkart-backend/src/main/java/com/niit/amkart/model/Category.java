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
@Table(name="CATEGORY")
@Component
public class Category 
{
	@Id
	@NotNull
	 @Pattern(regexp="^[Cc][0-9]{3}$", message="Should start with C")
	@Length(max=4,min=4, message ="Length should be 4")
	private String categoryID;
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
	private String categoryName;
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER, mappedBy="category")
	private Set<Product> products=new HashSet<Product>(0);
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
