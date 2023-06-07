package com.controller;

public class StringDemo1 {
	public static void main(String[] args) {
		/* There are 2 ways in which we can create the String */
		
		/* 1. Create literals 
		 * 2. Create Objects 
		 */
		
		//Literal : it goes in the pool : special memory give to string by jvm 
		/* Speciality of pool: it does not take duplicates and its immutable. */
		
		String s1 = "harry";
		
		//Object : it goes in the heap 
		String sObj = new String("harry");
		 
		System.out.println(s1);
		System.out.println(sObj);
		
		s1 = "harry potter";
		
		s1 = "harry";
		
		//comparision 
		System.out.println(s1 == sObj); //10X == 100X? false
		
		System.out.println(s1.equals(sObj));//"harry".equals("harry") : true
		
		/* Notable String methods */
		System.out.println(s1.toUpperCase());//HARRY
		
		s1.concat(" potter");
		
		System.out.println(s1); //"harry", no pooter Y? U did not assign the new value to s1 at 34.
		s1 = s1.concat(" potter");
		System.out.println(s1); //harry potter
		
		/* split */
		String[] sarry = s1.split(" "); //["harry","potter"]
		String fname = sarry[0];
		String lname = sarry[1];
		System.out.println(fname);
		System.out.println(lname);
		
		String email="anil@gmail.com";
		
		System.out.println("Welcome " + email.split("@")[0]);
	}
}
