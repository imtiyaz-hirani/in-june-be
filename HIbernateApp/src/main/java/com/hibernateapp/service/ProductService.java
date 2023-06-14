package com.hibernateapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernateapp.exception.ResourceNotFoundException;
import com.hibernateapp.model.Product;
import com.hibernateapp.persistence.ProductRepository;

public class ProductService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public ProductService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	public void save(Product product) {
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
	}

	public List<Product> getAll() {
		entityTransaction.begin();
		List<Product> list = ProductRepository.getAll(entityManager);
		entityTransaction.commit();
		return list;
	}

	public Product validateId(int id) throws ResourceNotFoundException {
		entityTransaction.begin();
		Product product = entityManager.find(Product.class, id);
		try {
		if(product == null)
			throw new ResourceNotFoundException("Invalid ID Given..");
		}
		finally {
			entityTransaction.commit();
		}
		
		return product; 
	}

	public void delete(Product prod) {
		entityTransaction.begin();
		entityManager.remove(prod);
		entityTransaction.commit();
		
	}

	public void update(Product prod) {
		entityTransaction.begin();
		entityManager.persist(prod); //try out: merge
		entityTransaction.commit();
	}

	public List<?> getByCategoryId(int catId) {
		entityTransaction.begin();
		List<?> list = ProductRepository.getByCategoryId(catId,entityManager);
		entityTransaction.commit();
		return list;
	}

}
//HQL: Hibernate Query Language / JPQL : java persistence query language 
