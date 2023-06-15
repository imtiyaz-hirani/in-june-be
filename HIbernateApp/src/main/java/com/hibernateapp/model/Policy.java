package com.hibernateapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Policy {
	@Id //this will make id as Primary key 
	@GeneratedValue(strategy = GenerationType.AUTO) //this makes it auto_incremental 
	private int id;
	
	private String name; 
	
	private double tenure;

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

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", name=" + name + ", tenure=" + tenure + "]";
	} 
	
	
}
