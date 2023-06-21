package com.springboot.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Customer;
import com.springboot.main.model.Product;
import com.springboot.main.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository; 
	
	public Customer insert(Customer customer) {
		 
		return customerRepository.save(customer);
	}

	public Customer getById(int customerId) {
		Optional<Customer> optional= customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			return null; 
		}
		return optional.get();
	}

}
