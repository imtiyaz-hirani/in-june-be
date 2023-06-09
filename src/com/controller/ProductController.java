package com.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.model.Product;
import com.service.ProductService;

public class ProductController {
	public static void main(String[] args) {
		  
 		
//		
//		for(Product p : list) {
//			System.out.println(p.getId() + "---" + p.getTitle() + "---" + p.getPrice());
//		}
//		
//		System.out.println("========Products having price>=20000======");
//		/* Only those products that have price>=20000 will be in the list */
//		list = list.stream()
//					.filter(p->p.getPrice() >= 20000)
//					.collect(Collectors.toList());
//		
//		for(Product p : list) {
//			System.out.println(p.getId() + "---" + p.getTitle() + "---" + p.getPrice());
//		}
		  
		/* Use Set for saving product objects. */
		Set<Integer> set  = new TreeSet<>();
		set.add(3);
		set.add(2);
		set.add(6);
		set.add(1);
		set.add(3);
		//set.add(null);
		System.out.println(set);
		
		List<Integer> list  = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(6);
		list.add(1);
		list.add(3);
		list.add(null); 
		
		list = list.stream()
			.filter(e->e != null)
			.distinct()
			.sorted()
			.collect(Collectors.toList());
		System.out.println(list);
		
		ProductService productService = new ProductService();
 		List<Product> listProducts = productService.getAllProducts();
 		listProducts.stream().forEach(System.out::println);
 		System.out.println("===set o/p===");
 		Set<Product> setProducts = new TreeSet<>(listProducts);
 		setProducts.stream().forEach(System.out::println);
	}
}













