package com.service;

import com.model.Customer;

public class CustomerService {

	public void deposit(Customer c1, int amount) {
		c1.setBalance(c1.getBalance() + amount);
	}

	

}
