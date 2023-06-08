package com.controller;

public class StringDemo {
	public static void main(String[] args) {
		try {
		/* Conversions */
		String s = "100"; 
		
		//convert this s to int String --> Integer 
		//Target class(Integer) has methods that can do the conversion for us 
		
		//String--> Integer
		int num = Integer.parseInt(s);
		System.out.println(num);
		
		//String --> Double 
		double val = Double.parseDouble(s);
		System.out.println(val);
		
		//String --> Float : if conversion does not happen then exception is thrown. 
		float f = Float.parseFloat(s + "a"); //100a
		System.out.println(f);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Thank you");
	}
}