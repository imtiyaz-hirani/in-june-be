package com.hibernateapp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernateapp.model.Category;

public class CategoryController {
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
		/* Read category input from User */
		System.out.println("Enter Category Name");
		String name = sc.next();
		/* Attach input values to category object */
		Category category = new Category();
		category.setName(name);
		
		/* Save the object in DB using entityManager */
		entityTransaction.begin();
		entityManager.persist(category);
		entityTransaction.commit();
		System.out.println("Category added in DB...");
	}
}
