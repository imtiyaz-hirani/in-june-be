package com.hibernateapp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernateapp.exception.ResourceNotFoundException;
import com.hibernateapp.model.PolicyHolder;
import com.hibernateapp.model.Product;

public class PolicyHolderService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public PolicyHolderService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	public PolicyHolder validateId(int phId) throws ResourceNotFoundException{
		entityTransaction.begin();
		PolicyHolder ph = entityManager.find(PolicyHolder.class, phId);
		try {
		if(ph == null)
			throw new ResourceNotFoundException("Invalid ID Given..");
		}
		finally {
			entityTransaction.commit();
		}
		
		return ph; 

	}

}
