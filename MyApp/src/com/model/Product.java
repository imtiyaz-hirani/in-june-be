package com.model;

public class Product implements Comparable<Product>{
	private int id;
	private String description;
	private String title;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", title=" + title + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product p2) { //this = p1
		 
		return (int)(p2.price - this.price); //ASC
	}

	
}
