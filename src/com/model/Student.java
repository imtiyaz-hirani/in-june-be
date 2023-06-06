package com.model;

public class Student extends College{
	private String name;
	private String address;
	 //id comes from college as it is public in BaseEntity
	 
	public Student(long id, String name, String address) {
		 this.id = id; 
		 this.name = name;
		this.address = address;
	}

	public Student() {
		 
	}

	@Override
	public void doTask() {
		System.out.println("task done");
		
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", cname=" + cname + ", id=" + id + "]";
	} 
	
	/* Override toString method of Object class, so that we get info of properties rather than location*/
	
}

/* 
 When a class(ex. Student) extends an abstract class(ex. College), it must override/implement
 all its abstract methods 
 */
