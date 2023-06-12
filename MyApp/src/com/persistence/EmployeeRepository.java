package com.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.exception.ResourceNotFoundException;
import com.model.Employee;

public interface EmployeeRepository 
				extends BaseRepository{

	public default List<Employee> getAll() {
		Employee e1 = new Employee(1L,"harry potter","london","IT",85000); 
		Employee e2 = new Employee(2L,"ronald weasley","kent","ADMIN",75000); 
		Employee e3 = new Employee(3L,"hermione granger","london","IT",95000);
		Employee e4 = new Employee(4L,"draco malfoy","surrey","SALES",90000);
		
		/* Add these object in the List(Container) */
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		/* return the list to service */
		return list; 
	}
	
	/* You will be given the list of employees and an ID of the employee. 
	 * From this list, return us the employee that has the given id. */
	public default Employee getById(List<Employee> list,Long id) 
			throws ResourceNotFoundException{
		//1. using filter of streams 
		//2. search method in list
		//3. use getById in JpaRepo ??? 
		//4. list[id] : won't work 
		//5. Iterate over list using for and then compare : manual
		
		for(Employee e : list) { //[e1,e2,e3,e4] -- e=e1(loop), e=e2(loop)
			if(e.getId() == id) {
				return e; 
			}
		}
		
		throw new ResourceNotFoundException("Invalid ID");
	}
	
	public default Employee getByIdStream(List<Employee> list,Long id) 
			throws ResourceNotFoundException{
		//1. using filter of streams 
		//[e1,e2,e3,e4] 
		 list = list.stream()    
				 .filter(e->e.getId() == id)
				 .collect(Collectors.toList());
		 // only the employee which matches the ID will stay in the list 
		 if(list.size() == 0)
			 throw new ResourceNotFoundException("Invalid ID");
		 return list.get(0);
	}
	
	public default Employee getByIdStream2(List<Employee> list,Long id) 
			throws ResourceNotFoundException{
		//1. using filter of streams 
		//[e1,e2,e3,e4] 
		 Employee emp = list.stream()    
				 .filter(e->e.getId() == id)
				 .findAny().orElse(null);
		 // only the employee which matches the ID will stay in the list 
		 if(emp == null)
			 throw new ResourceNotFoundException("Invalid ID");
		 return emp;
	}
	
	public default void deleteOne(List<Employee> list,Long id) {
		//delete the object from the list that matches id 
		
		//do it as an assignment exercise 
	}
	
	
	
}
//70% : 30% 