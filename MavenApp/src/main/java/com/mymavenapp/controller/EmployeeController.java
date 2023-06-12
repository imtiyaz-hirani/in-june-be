package com.mymavenapp.controller;

import java.util.List;
import java.util.Scanner;

import com.mymavenapp.exception.ResourceNotFoundExeption;
import com.mymavenapp.model.Employee;
import com.mymavenapp.service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) {
		/* connect to EmployeeService */
		EmployeeService service = new EmployeeService();
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee(); 
		
		while(true) {
			System.out.println("==========Employee Operations========");
			System.out.println("1. Insert Employee");
			System.out.println("2. Display all Employees");
			System.out.println("3. Delete Employee");
			System.out.println("4. Update Employee");
			System.out.println("0. Exit");
			int input = sc.nextInt();
			if(input == 0 ) {
				System.out.println("Exiting.. Bye");
				break; //breaking the while loop 
			} //if ends
			
			switch(input) {
			case 1: 
				System.out.println("Enter employee Name: ");
				employee.setName(sc.next());
				System.out.println("Enter employee city: ");
				employee.setCity(sc.next());
				System.out.println("Enter employee Salary: ");
				employee.setSalary(sc.nextDouble());
				int status = service.save(employee);
				System.out.println(status==1?"Employee saved":"Error in saving employee");
				break;
			case 2: 
				List<Employee> list = service.getAll();
				list.stream().forEach(System.out:: println);
				break;
			case 3:
				System.out.println("Enter employee ID to delete");
				int id = sc.nextInt();
				//validate the id before you delete
				try {
					service.validateId(id);
					//since the id is valid, delete the record from the DB 
					status = service.delete(id);
					System.out.println(status==1?"Employee deleted":"Error in deleting employee");
				} catch (ResourceNotFoundExeption e) {
					 System.out.println(e.getMessage());
				}
				break;
			case 4: 
				System.out.println("Enter employee ID to update");
				id = sc.nextInt();
				employee.setId(id);
				//validate the id before you delete
				try {
					service.validateId(id);
					//since the id is valid, update the record in the DB 
					System.out.println("----Enter new values----");
					System.out.println("Enter employee Name: ");
					employee.setName(sc.next());
					System.out.println("Enter employee city: ");
					employee.setCity(sc.next());
					System.out.println("Enter employee Salary: ");
					employee.setSalary(sc.nextDouble());
					status = service.update(employee);
					System.out.println(status==1?"Employee updated":"Error in updating employee");
				} catch (ResourceNotFoundExeption e) {
					 System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid input, Try again..");
				break; 
			} //switch ends
		} //while ends
	} //main ends
} //class ends
