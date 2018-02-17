package com.model;

import java.awt.Image;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Component
@Table(name="Product")
public class Product implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String description;
	private  Float price;
	private int stock;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
    private Category category;// fields are in object form
	@ManyToOne
	@JoinColumn(name="sid")
	private Supplier supplier; // fields are in object form
	
	
	
	@Transient
	MultipartFile pimage;// object field and it will NOT BE SAVED IN DB
	
	private String imgname;// this image name field will help us in 
	// mapping every product ID with it's corresponding image

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	
	
	
	
}





