package com.utility;

import java.util.Comparator;

import com.model.Employee;

public class SortUtility implements Comparator<Employee>{

	private String direction; 
	
	public SortUtility(String direction) {
		this.direction = direction;
	}
	@Override
	public int compare(Employee e1, Employee e2) {
		 if(direction.equals("ASC"))
			 	return (int)(e1.getSalary() - e2.getSalary());
		 else
			 	return (int)(e2.getSalary() - e1.getSalary());
	}

}
