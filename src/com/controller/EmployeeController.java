package com.controller;

import java.util.List;

import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) { 
		//to display output in console i need this method
		
		/* Reach out to SERVICE class : create object */
		//A: A a=new A(); 
		
		EmployeeService employeeService = new EmployeeService();
		
		/* call the method */
		List<Employee> list = employeeService.getAllEmployees();
		
		for(Employee e : list) { //[e1,e2,e3]  -- e=e1 (loop) , e=e2 (loop), e=e3 (loop)
			System.out.println(e.getId() + "--" + e.getName()) ;
		}
	}
}
