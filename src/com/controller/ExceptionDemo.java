package com.controller;

import com.exception.DivideByZeroException;
import com.exception.InvalidInputException;

public class ExceptionDemo {
	public static void main(String[] args) { //thread: main
		A a=new A(); 
		try {
			int result = a.compute(12,4);
			System.out.println("Result is " + result);
		} catch (DivideByZeroException | InvalidInputException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("thank you");
	}
}

class A{ //you are this programmer : service class 
	public int compute(int i, int j) throws DivideByZeroException,InvalidInputException{
		  
		if(j == 0) { //validating j and throwing exception
			throw new DivideByZeroException("Divide by zero is not allowed");
		}
		if(j<0) { //-ve number
			throw new InvalidInputException("deno cannot be negative");
		}
		if(j>i) { //
			throw new InvalidInputException("deno cannot be > than numerator");
		}
		// perform divide
		 return i/j;
	}
}
