package com.springboot.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Product;
import com.springboot.main.model.Supplier;
import com.springboot.main.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository; 
	
	public Supplier insert(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	public Supplier getById(int supplierId) {
		Optional<Supplier> optional= supplierRepository.findById(supplierId);
		if(!optional.isPresent()) {
			return null; 
		}
		return optional.get();	}

}
