package com.hibernateapp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernateapp.model.Policy;
import com.hibernateapp.model.PolicyHolder;

public class PolicyHolderController {
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
		 
		PolicyHolder policyHolder = new PolicyHolder();
		entityTransaction.begin();
		System.out.println("----Enter policy holder details-----");
		
		System.out.println("Enter name");
		policyHolder.setName(sc.nextLine());
		System.out.println("Enter age");
		policyHolder.setAge(sc.nextInt());
		System.out.println("Enter city");
		policyHolder.setCity(sc.next());
		
		entityManager.persist(policyHolder);
		entityTransaction.commit();
		System.out.println("policy holder added to DB..");
	}
}
