package com.niit.amkart.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Component;

@Entity
@Table(name="USER")
@Component
public class User {

	private static final long serialVersionUID = 1L;
	@Id 
	@NotNull
	private String email;
	@NotEmpty(message="Cant be blank")
	private String name;
	
	private String password;
	private boolean enabled;
	private String role;
	private String address;
	@NotNull
    @Length(max=10,min=10,message="Phone number is not valid. Should be of length 10.")
	@NumberFormat(style= Style.NUMBER)
	private String phone;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	@OneToMany(targetEntity=Orders.class,mappedBy="userName")
	private Set<Orders> order=new HashSet<Orders>(0);
	public Cart getCart() {
		return cart;
	}
	public Set<Orders> getOrder() {
		return order;
	}
	public void setOrder(Set<Orders> order) {
		this.order = order;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	@NotNull(message="Email Address is compulsory")
    @NotBlank(message="Email Address is compulsory")
    @Email(message = "Email Address is not a valid format")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotNull(message = "Name is compulsory")
    @NotBlank(message = "Name is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "First name has invalid characters")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
