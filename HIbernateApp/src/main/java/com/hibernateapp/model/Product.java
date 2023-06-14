package com.hibernateapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity //hibernate will create product table 
public class Product {
	@Id //this will make id as Primary key 
	@GeneratedValue(strategy = GenerationType.AUTO) //this makes it auto_incremental 
	private int id;
	
	@Column(name = "ptitle") //by default, String will be of varchar(255) size
	private String title;
	
	private double price;
	
	@Column(length = 2000) //this will reserve varchar(2000) chars for description
	private String description;

	@OneToOne //cateogry_id will be created inside product table
	private Category category; 
	
	@ManyToOne //vendor_id will be created inside product table 
	private Vendor vendor;
	
	
	//select p from Product p where p.category.id=?
	//Note: for Java Pro: OneToOne has Similar effect as of ManyToOne
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description + "]";
	}

}
