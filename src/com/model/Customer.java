package com.model;

public class Customer {
	private int id;
	private String name;
	private String city;
	private double balance;
	
	//Role of constructor is to initialize instance variables 
	public Customer(int id, String name, String city, double balance) { 
		this.id = id;
		this.name = name;
		this.city = city;
		this.balance = balance;
	}
	
	public Customer() {
		 
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}