package com.mymavenapp.exception;

public class ResourceNotFoundExeption extends Exception{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundExeption(String message) {
		super(message);
	}
}
