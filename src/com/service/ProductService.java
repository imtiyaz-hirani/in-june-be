package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductService {
	
	public List<Product> getAllProducts() {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		p1.setId(1);
		p1.setTitle("Oppo Mobile");
		p1.setDescription("This is oppo phone");
		p1.setPrice(18000);
		
		p2.setId(2);
		p2.setTitle("Apple Mobile");
		p2.setDescription("This is iphone");
		p2.setPrice(38000);
		
		p3.setId(3);
		p3.setTitle("OnePlus Mobile");
		p3.setDescription("This is nord phone");
		p3.setPrice(28000);
		
		List<Product> list = new ArrayList<>();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		return list; 
	}
}
