package com.exception;

public class DivideByZeroException extends Exception{
	//to make my custom class an exception class, I must extend it with Exception class. 

	public DivideByZeroException(String message) {
		//this message local variable value must be passed on to super class
		super(message);
	}
}
