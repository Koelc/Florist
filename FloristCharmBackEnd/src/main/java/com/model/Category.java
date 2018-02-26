package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Entity
@Component
@Table(name="Category")
public class Category {

@Id
private int cid;
private String name;
//private float tax;
@OneToMany(targetEntity=Product.class,  fetch=FetchType.EAGER, mappedBy="category")
private Set<Product> products = new HashSet<Product>(0);


/*private Product prod;// find a product against a cat or supplier
*/

/*public Product getProd() {
	return prod;
}
public void setProd(Product prod) {
	this.prod = prod;
}*/
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Product> getProducts() {
	return products;
}
public void setProducts(Set<Product> products) {
	this.products = products;
}


}
