package com.model;
 //encapsulation 
public class Employee  extends BaseEntity implements Comparable<Employee>{
	   
	private String name;
	private String city; 
	private String department; 
	private double salary;
	
	
	public Employee(long id, String name, String city, String department, double salary) {
		this.id = id; 
		this.name = name;
		this.city = city;
		this.department = department;
		this.salary = salary;
	}

	
	public Employee() { }


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [id="+ id +", name=" + name + ", city=" + city + ", department=" + department + ", salary=" + salary + "]";
	}


	@Override
	public int compareTo(Employee e2) { 
		//to give criteria of sorting between 2 employees, u must use this operator 
		/* this : employee 1 */
		/* e2: employee 2 */
		 
		return (int) (this.salary - e2.salary);
	} 
	
	
}
