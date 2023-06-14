package com.hibernateapp.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.hibernateapp.exception.ResourceNotFoundException;
import com.hibernateapp.model.Category;
import com.hibernateapp.model.Vendor;

public class VendorService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	public VendorService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	public Vendor validateId(int vendorId) throws ResourceNotFoundException{
		 entityTransaction.begin();
		 Vendor vendor = entityManager.find(Vendor.class, vendorId);
		try {
		 if(vendor == null)
			 throw new ResourceNotFoundException("Invalid ID Given..");
		}
		finally {
		 entityTransaction.commit();
		}
		return vendor;
	}

}
