package com.model;

public class Test { 
	public static void main(String[] args) {
		B b = new B(); 
		b.m1();
		b.m2();
	}
}

class A{ //super
	 
	void m1() {
		System.out.println("m1 in A");	 //m1 of A 
	}
}

class B extends A{ //sub
	//all the methods of A now are part of B
	
	void m2() {
		System.out.println("m2 of B");
	}
	
	void m1() { //overriding m1 method 
		System.out.println("m1 of A");
	}
}

/* Inheritance : 2 thigs 
 a. add new functionality: add new method 
 b. change/alter existing functionality 
 */