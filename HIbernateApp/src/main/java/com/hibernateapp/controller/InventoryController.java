package com.hibernateapp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernateapp.exception.ResourceNotFoundException;
import com.hibernateapp.model.Category;
import com.hibernateapp.model.Product;
import com.hibernateapp.model.Vendor;
import com.hibernateapp.service.CategoryService;
import com.hibernateapp.service.ProductService;
import com.hibernateapp.service.VendorService;

public class InventoryController {
	public static void main(String[] args) {
		/* connect to persistence.xml file and load persistence-unit */
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("in_june_be");
		
		/* Using factory, we need to set up EntityManager which will help us perform ops */
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		
		/* To perform DB ops, hibernate wants developers to begin and commit the transactions. 
		 * For this we need to setup EntityTransaction using EntityManager. */
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner sc = new Scanner(System.in);
		
		CategoryService categoryService = new CategoryService(entityManager,entityTransaction);
		VendorService vendorService = new VendorService(entityManager,entityTransaction);
		ProductService productService = new ProductService(entityManager,entityTransaction);

		while(true) {
			System.out.println("====Inventory Ops=====");
			System.out.println("1. Insert Product");
			System.out.println("2. List all products by category ID");
			System.out.println("3. Delete the product");
			System.out.println("4. Update Product");
			System.out.println("0. Exit");
			int input=sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting.. Bye..");
				break; 
			}//if ends
			
			switch(input) {
			case 1: 
				Product product = new Product();
				System.out.println("Enter product title");
				sc.nextLine();
				product.setTitle(sc.nextLine());
				System.out.println("Enter price");
				product.setPrice(sc.nextDouble());
				System.out.println("Enter product description");
				sc.nextLine();
				product.setDescription(sc.nextLine());
				System.out.println("Enter category ID");
				int catId = sc.nextInt();
				/* STEP 1: Validate catId : if found: return category object */
				Category category = null;
				try {
					category = categoryService.validateId(catId);
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.println("Enter vendor ID");
				int vendorId = sc.nextInt();
				/* STEP 2:  Validate vendorId : if found: return vendor object */
				Vendor vendor = null;
				try {
					vendor = vendorService.validateId(vendorId);
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
					break;
				}
				/* STEP 3: Attach category and vendor objects to product object */
				 product.setCategory(category);
				 product.setVendor(vendor);
				 
				/* STEP 4: Save product object */
				 productService.save(product);
				 System.out.println("Product saved in DB..");
				break;
			case 2: 
				System.out.println("Enter Category ID");
				catId = sc.nextInt();
				try {
					category = categoryService.validateId(catId);
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
					break;
				}
				List<?> productList =  productService.getByCategoryId(catId);
				productList.stream().forEach(System.out :: println);
				break; 
			}
			
			
		}//while ends	
	}
}
