package com.hibernateapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "policy_holder")
public class PolicyHolder {
	@Id //this will make id as Primary key 
	@GeneratedValue(strategy = GenerationType.AUTO) //this makes it auto_incremental 
	private int id;
	
	private String name; 
	
	private int age; 
	
	private String city;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "PolicyHolder [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	} 
	
	
}
