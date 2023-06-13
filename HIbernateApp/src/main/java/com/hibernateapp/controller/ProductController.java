package com.hibernateapp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernateapp.exception.ResourceNotFoundException;
import com.hibernateapp.model.Product;
import com.hibernateapp.service.ProductService;

public class ProductController {
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
		ProductService productService = new ProductService(entityManager,entityTransaction);
		
		while(true) {
			System.out.println("====Hibernate Ops====");
			System.out.println("1. Insert Product");
			System.out.println("2. List all products");
			System.out.println("3. Delete the product");
			System.out.println("4. Update Product");
			System.out.println("0. Exit");
			int input=sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting.. Bye..");
				break; 
			}
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
				productService.save(product);
				System.out.println("Product saved in DB...");
				break; 
			case 2: 
				List<Product> list = productService.getAll();
				list.stream().forEach(System.out:: println);
				break; 
			case 3: 
				System.out.println("Enter product id");
				int id = sc.nextInt();
				try {
					Product prod = productService.validateId(id);
					productService.delete(prod);
					System.out.println("Record Deleted from the DB..");
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter product id");
				id = sc.nextInt();
				try {
					Product prod = productService.validateId(id);
					/* Read the new values from user */
					System.out.println("Enter new values to update");
					System.out.println("Enter product title");
					sc.nextLine();
					prod.setTitle(sc.nextLine());
					System.out.println("Enter price");
					prod.setPrice(sc.nextDouble());
					System.out.println("Enter product description");
					sc.nextLine();
					prod.setDescription(sc.nextLine());
					productService.update(prod);
					System.out.println("Record Updated from the DB..");
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break; 
			default: 
				System.out.println("Invalid Input, Try Again..");
			}//switch ends
		
		}//while ends
	} //main ends
}//class ends

/*
 * Assumption: JVM must auto search for META-INF folder in java folder, and
 * within META-INF it shd find persistence.xml
 */

/*
 * In older hibernate version, Instead of EntityManagerFactory, we used
 * SessionFactory. But now, its a good practice to use EntityManagerFactory as
 * it is better than all other factory classes/interfaces
 */
