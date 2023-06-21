package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.CustomerProduct;
import com.springboot.main.repository.CustomerProductRepository;

@Service
public class CustomerProductService {

	@Autowired
	private CustomerProductRepository customerProductRepository;
	
	public CustomerProduct insert(CustomerProduct customerProduct) {
		 
		return customerProductRepository.save(customerProduct);
	}

}
