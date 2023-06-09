package com.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.model.Product;
import com.service.ProductService;

public class ProductController {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		List<Product> list = productService.getAllProducts();
		
		for(Product p : list) {
			System.out.println(p.getId() + "---" + p.getTitle() + "---" + p.getPrice());
		}
		
		System.out.println("========Products having price>=20000======");
		/* Only those products that have price>=20000 will be in the list */
		list = list.stream()
					.filter(p->p.getPrice() >= 20000)
					.collect(Collectors.toList());
		
		for(Product p : list) {
			System.out.println(p.getId() + "---" + p.getTitle() + "---" + p.getPrice());
		}
	}
}
