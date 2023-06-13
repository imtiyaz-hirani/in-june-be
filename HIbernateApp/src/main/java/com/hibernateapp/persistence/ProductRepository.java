package com.hibernateapp.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import com.hibernateapp.model.Product;

public interface ProductRepository {

	static List<Product> getAll(EntityManager entityManager) {
		List<Product> list = entityManager.createQuery("select p from Product p",Product.class).getResultList();
		return list;
	}

}
