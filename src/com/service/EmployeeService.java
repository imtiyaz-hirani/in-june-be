package com.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.model.Employee;
import com.persistence.EmployeeRepository;
import com.utility.SortUtility;

public class EmployeeService implements EmployeeRepository{

	public List<Employee> getEmployeesInSortedOrderOfSalary(List<Employee> list, String direction) {
		//check if direction is ASC or DESC 
		//sort the list of employee on the basis of salary 
		
		/* Type 1: using comparable interface */
		Collections.sort(list);//[e1,e2,e3,e4]
		/* Collections.sort() checks for criteria of sorting in Model class(Employee) */
		
		/* Use Comparable interface, to define the criteria*/
		
		return list; 
	}

	public List<Employee> getEmployeesInSortedOrderOfSalaryComparator(List<Employee> list, 
			String direction) {
		
		if(direction.equals("ASC")) {
			Collections.sort(list,new SortUtility("ASC"));
		}
		else { //DESC
			Collections.sort(list,new SortUtility("DESC"));
		}
		return list;
	}

	public List<Employee> getEmployeesInSortedOrderOfSalaryUsingStream(List<Employee> list) {
		list = list.stream()
		.sorted((e1,e2)->e2.getSalary().compareTo(e1.getSalary()))
		.collect(Collectors.toList());
		return list;
	}
	
}

/* 
 Sorting can have 3 approches
 1. Using Comparable interface 
 2. Using Comparator interface
 3. Using Streams 
 */

/* 
 TO sort the list we can use Collectios.sort() method
 */
