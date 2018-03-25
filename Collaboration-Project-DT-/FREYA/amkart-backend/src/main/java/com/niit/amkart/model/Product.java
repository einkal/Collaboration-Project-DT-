package com.niit.amkart.model;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT")
@Component
public class Product {
	@GeneratedValue
	@Id
	private int productID;
	@NotEmpty(message="Cant be blank")
	private String productName;
	@NotEmpty(message="Cant be blank")
	private String description;
	private Float price;
	private int stock;
	private String imageName;
	@Transient
	MultipartFile productImage;
	private String categoryID;
	private String supplierID;
	
	
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	@Min(value = 10, message = "Atleast 10 items should be in stock ")
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="categoryID", nullable = false, updatable = false, insertable = false)
	private Category category;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="supplierID", nullable = false, updatable = false, insertable = false)
	private Supplier supplier;
	
	/*@OneToMany(targetEntity=CartItem.class,cascade = CascadeType.ALL, mappedBy="product")
	private Set<CartItem> cartItems=new HashSet<CartItem>(0);*/
	
}
