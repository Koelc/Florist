package com.model;

import java.io.Serializable;
import java.util.HashSet;
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

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Entity
@Component
@Table(name="Cart")

public class Cart implements Serializable
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
	private int cartId;
  //product id should be mapped to cartProductID
   //for this we will use @PathVariable
  private int cartProductId;
  
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="userMailId")
  private User cartUserDetails;
  
  private Double cartPrice;
  
  private int cartQuantity;
  
  private String cartImage;// prod image name in cart
	
  private String cartProductName;
  
  public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}

public int getCartProductId() {
	return cartProductId;
}

public void setCartProductId(int cartProductId) {
	this.cartProductId = cartProductId;
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

public String getCartImage() {
	return cartImage;
}

public void setCartImage(String cartImage) {
	this.cartImage = cartImage;
}

public String getCartProductName() {
	return cartProductName;
}

public void setCartProductName(String cartProductName) {
	this.cartProductName = cartProductName;
}

public Cart()
  {
	  
  }
  
  public Cart(int cartId,int cartProductId,User cartUserDetails,Double cartPrice,int cartQuantity )
  {
	  this.cartId = cartId;
	  this.cartProductId = cartProductId;
	  this.cartUserDetails = cartUserDetails;
	  this.cartPrice = cartPrice;
	  this.cartQuantity = cartQuantity;
	  
  }
}












