package com.controller;

import com.model.BaseEntity;
import com.model.Student;

public class keywordsApp {
	public static void main(String[] args) {
		Student s1 = new Student(1,"imtiyaz","mumbai");
		System.out.println(s1.getCname());
		s1.doTask();
		
		//BaseEntity entity = new BaseEntity();//100X - cannot create an object as BE is abstract
	/* 
		entity.id = 45; //cannot access id as it is protected. 
		
		entity.setId(45);
		
		entity.getId()
		*/
		
		System.out.println(s1); //Student [name=imtiyaz, address=mumbai, cname=ACS Institute of Tech, id=1]
		//because of toString i get info rather than mem. loc
	}
}
