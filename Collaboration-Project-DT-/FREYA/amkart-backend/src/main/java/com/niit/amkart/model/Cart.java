package com.niit.amkart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.niit.amkart.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Entity
@Table(name="CART")
public class Cart implements Serializable
{
	
	@Id
	@GeneratedValue
	private int cartID;
	private int cartProductID;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UserEmail")
	private User cartUserDetails;
	private Double cartPrice;
	private int cartQuantity;
	
	@OneToMany(targetEntity=Orders.class,mappedBy="orderCartID")
	private Set<Orders> orders=new HashSet<Orders>(0);
	
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	@OneToMany(mappedBy ="cart",fetch=FetchType.EAGER)
	private List<CartItem> cartItem;
	
	public List<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	
	public Cart(int cartID, int cartProductID, User cartUserDetails, Double cartPrice, int cartQuantity,
			List<CartItem> cartItem) {
		super();
		this.cartID = cartID;
		this.cartProductID = cartProductID;
		this.cartUserDetails = cartUserDetails;
		this.cartPrice = cartPrice;
		this.cartQuantity = cartQuantity;
		this.cartItem = cartItem;
	}
	public Cart()
	{
		
	}
	public int getCartID() {
		return cartID;
	}
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	public int getCartProductID() {
		return cartProductID;
	}
	public void setCartProductID(int cartProductID) {
		this.cartProductID = cartProductID;
	}
	public User getCartUserDetails() {
		return cartUserDetails;
	}
	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}
	public Double getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
		
	
}
