package com.hibernateapp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernateapp.exception.ResourceNotFoundException;
import com.hibernateapp.model.Category;

public class CategoryService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public CategoryService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	public Category validateId(int catId) throws ResourceNotFoundException {
		 entityTransaction.begin();
		 Category category = entityManager.find(Category.class, catId);
		try {
		 if(category == null)
			 throw new ResourceNotFoundException("Invalid ID Given..");
		}
		finally {
		 entityTransaction.commit();
		}
		return category;
	}

}
