package com.hibernateapp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernateapp.exception.ResourceNotFoundException;
import com.hibernateapp.model.Policy;
import com.hibernateapp.model.PolicyHolder;

public class PolicyService {
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public PolicyService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	public Policy validateId(int pid)  throws ResourceNotFoundException{
		entityTransaction.begin();
		Policy policy = entityManager.find(Policy.class, pid);
		try {
		if(policy == null)
			throw new ResourceNotFoundException("Invalid ID Given..");
		}
		finally {
			entityTransaction.commit();
		}
		
		return policy; 
	}

}
