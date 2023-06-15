package com.hibernateapp.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hibernateapp.model.Policy;

public interface PhpRepository {

	static List<?> getAllPoliciesByPHid(int phId, EntityManager entityManager) {
		Query query =  entityManager
				.createQuery("select php.policy from PolicyHolderPolicy php where php.policyHolder.id=:id", Policy.class);
		query.setParameter("id", phId);
		List<?> list = query.getResultList();
		return list;
	}

}
