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
@Table(name="Supplier")
public class Supplier 
{
@Id
private int sid;

private String supplierName;
@OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER,mappedBy="supplier")
private Set<Product> product = new HashSet<Product>(0);
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}

public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}


}
