package com.controller;

import java.util.List;
import java.util.Scanner;

import com.exception.ResourceNotFoundException;
import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) { 
		
		Scanner sc = new Scanner(System.in);
		EmployeeService employeeService = new EmployeeService();
		List<Employee> list = employeeService.getAll();
		while(true) {
			System.out.println("1. Employee List");
			System.out.println("2. Fetch Employee by id");
			System.out.println("3. Fetch employee by id using stream");
			System.out.println("4. Fetch employee by id using stream orElse method");
			System.out.println("5. Sort Employees as per salary: ASC");
			System.out.println("6. Sort Employees as per salary: DESC");
			System.out.println("7. Sort Employees as per salary");
			System.out.println("0. Exit");
			int input = sc.nextInt(); 
			if(input ==0) {
				System.out.println("Exiting...");
				break; 
			}
			switch(input) {
			case 1:
				System.out.println("=====ALL EMPLOYEES=====");
				list.stream().forEach(System.out :: println);
				break;
			case 2:
				System.out.println("===Fetch employee by id===");
				System.out.println("Enter employee id to fetch record: ");
				long id = sc.nextLong();
				
				try {
					Employee  e = employeeService.getById(list, id);
					System.out.println(e);
				} catch (ResourceNotFoundException e1) {
					 System.out.println(e1.getMessage());
				}
				break;
			case 3:
				System.out.println("===Fetch employee by id using stream ===");
				System.out.println("Enter employee id to fetch record: ");
				id = sc.nextLong();
				try {
					Employee  e = employeeService.getByIdStream(list, id);
					System.out.println(e);
				} catch (ResourceNotFoundException e1) {
					 System.out.println(e1.getMessage());
				}
				break;
			case 4:
				System.out.println("===Fetch employee by id using stream orElse method ===");
				System.out.println("Enter employee id to fetch record: ");
				id = sc.nextLong();
				try {
					Employee  e = employeeService.getByIdStream2(list, id);
					System.out.println(e);
				} catch (ResourceNotFoundException e1) {
					 System.out.println(e1.getMessage());
				}
				break;
			case 5:
				list = employeeService.getEmployeesInSortedOrderOfSalary(list, "ASC");
				list.stream().forEach(System.out :: println);
				break;
			case 6:
				list = employeeService.getEmployeesInSortedOrderOfSalaryComparator(list,"ASC");
				list.stream().forEach(System.out :: println);
				break;
			case 7:
				list = employeeService.getEmployeesInSortedOrderOfSalaryUsingStream(list);
				list.stream().forEach(System.out :: println);
				break;
			default:
				System.out.println("Enter valid option...Try Again...");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
