package com.hibernateapp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernateapp.exception.ResourceNotFoundException;
import com.hibernateapp.model.Policy;
import com.hibernateapp.model.PolicyHolder;
import com.hibernateapp.model.PolicyHolderPolicy;
import com.hibernateapp.service.PHPService;
import com.hibernateapp.service.PolicyHolderService;
import com.hibernateapp.service.PolicyService;

public class PolicyHolderPOlicyController {
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
		PolicyService policyService = new PolicyService(entityManager,entityTransaction);
		PolicyHolderService phService = new PolicyHolderService(entityManager,entityTransaction);
		PHPService phpService = new PHPService(entityManager,entityTransaction);
		while(true) {
			System.out.println("1. Purchase Policy");
			System.out.println("2. Policy Record");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			
			if(input == 0) {
				System.out.println("Exiting.. Bye..");
				break; 
			}
			switch(input) {
			case 1: 
				System.out.println("Enter Policy Holder ID: ");
				int phId = sc.nextInt();
				/* Step 1: Validate phId and return PH object */
				PolicyHolder ph=null;
				try {
					ph = phService.validateId(phId);
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.println("Enter Policy Id: ");
				int pid = sc.nextInt();
				/* Step 2: validate pid and fetch policy object*/
				Policy policy=null;
				try {
					policy = policyService.validateId(pid);
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
					break;
				}
				
				LocalDate dateOfRegistration = LocalDate.now();
				
				System.out.println("Enter the premium you wish to pay per annum");
				double premium = sc.nextDouble();
				
				/* Step 3: Create PHP(PolicyHolderPOlicy) object and attach PH and Policy to it*/
				PolicyHolderPolicy php = new PolicyHolderPolicy();
				php.setPolicy(policy);
				php.setPolicyHolder(ph);
				php.setDateOfRegistration(dateOfRegistration);
				php.setPremium(premium);
				
				/* Step 4: Persist PHP object */
				phpService.save(php);
				System.out.println("Policy puchase successfull...");
				break;
				
			case 2:
				System.out.println("Enter Policy Holder ID: ");
				phId = sc.nextInt();
				/* Step 1: Validate phId and return PH object */
				try {
					ph = phService.validateId(phId);
				} catch (ResourceNotFoundException e) {
					System.out.println(e.getMessage());
					break;
				}
				
				/* Step 2: go to phpService and fetch policy records*/
				List<?> list = phpService.getPolicies(phId);
				list.stream().forEach(System.out :: println);
				break; 
			}
		}
	}
}//List<Policy> : policy 				condition: phId
