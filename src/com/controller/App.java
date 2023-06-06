package com.controller;

import com.model.Customer;
import com.service.CustomerService;

public class App {
	public static void main(String[] args) {
		/* create multiple customers of the bank */
		Customer c1 = new Customer(1,"harry potter","london",120000); //100X 
		
		Customer c2 = new Customer();  //200X
		c2.setId(2);
		c2.setName("ronald weasley");
		c2.setCity("kent");
		c2.setBalance(90000);
		
		/* I want to maintain balance of customers after deposit and withdrawal operation */
		System.out.println(c1);
		System.out.println(c2);
		
		CustomerService service = new CustomerService();
		service.deposit(c1, 20000);
		System.out.println(c1.getBalance()); //140000
		
		service.deposit(c2, 10000);
		System.out.println(c2.getBalance()); //100000
		
		/* How can i manage the memory better */
		c1=null;
		c2=null;
		
	}
}
