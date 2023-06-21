package com.hibernateapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernateapp.model.PolicyHolderPolicy;
import com.hibernateapp.persistence.PhpRepository;

public class PHPService {
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public PHPService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	public void save(PolicyHolderPolicy php) {
		entityTransaction.begin();
		entityManager.persist(php);
		entityTransaction.commit();
		
	}

	public List<?> getPolicies(int phId) {
		entityTransaction.begin();
		List<?> list = PhpRepository
				.getAllPoliciesByPHid(phId,entityManager);
		entityTransaction.commit();
		return list;
	}

}
