package com.mymavenapp.service;

import java.sql.Connection;
import java.util.List;

import com.mymavenapp.exception.ResourceNotFoundExeption;
import com.mymavenapp.model.Employee;
import com.mymavenapp.persistence.EmployeeRepository;

public class EmployeeService implements EmployeeRepository{

	public int save(Employee employee) {
		Connection con = dbConnect();
		int status = save(employee,con);
		//once the op is done, close the connection 
		dbClose(con);
		return status;
	}

	public List<Employee> getAll() {
		Connection con = dbConnect();
		List<Employee> list = getAll(con);
		dbClose(con);
		return list;
	}

	public void validateId(int id) throws ResourceNotFoundExeption{
		Connection con = dbConnect();
		boolean isPresent = getById(id,con);
		if(isPresent == false) {
			throw new ResourceNotFoundExeption("Given ID does not exist in the DB. ");
		}
		dbClose(con);
	}

	public int delete(int id) {
		Connection con = dbConnect();
		int status = delete(id,con);
		dbClose(con);
		return status;
	}

	public int update(Employee employee) {
		Connection con = dbConnect();
		int status = update(employee,con);
		dbClose(con);
		return status;
	}

	

	//Service is getting dbConnect() and dbClose() from Repo 
}