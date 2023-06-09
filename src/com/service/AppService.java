package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

public class AppService {

	public List<Employee> getAllEmployees() {
		/* Creating Employees */
		Employee e1 = new Employee(); //ctrl + shft + O
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		
		/* Set values to Employees: e1, e2, e3 */
		e1.setId(1);
		e1.setName("harry potter");
		e1.setCity("london");
		e1.setDepartment("IT");
		e1.setSalary(85000);
		
		e2.setId(2);
		e2.setName("ronald weasley");
		e2.setCity("kent");
		e2.setDepartment("ADMIN");
		e2.setSalary(75000);
		
		e3.setId(3);
		e3.setName("hermione granger");
		e3.setCity("london");
		e3.setDepartment("IT");
		e3.setSalary(95000);
		
		/* create the container to save all objects */
		List<Employee> container = new ArrayList<>();
		
		/* Add objects to container */
		container.add(e1);
		container.add(e2);
		container.add(e3);
		
		/* return the container */
		return container; 
	}
}

//A : A a = new A(); 
//C : C c = new C(); 
