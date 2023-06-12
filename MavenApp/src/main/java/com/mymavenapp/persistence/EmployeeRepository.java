package com.mymavenapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mymavenapp.model.Employee;
 

public interface EmployeeRepository extends BaseRepository{

	//this repo has dbConnect and dbClose method from BaseRepository
	
	public default int save(Employee employee,Connection con){
		int status = 0; 
		/* To execute the query we need to prepare the statement */
		String query="insert into employee(name,city,salary) values (?,?,?)";
		try {
			PreparedStatement pstmt =   con.prepareStatement(query);
			/* Once the statement is prepared, we execute the query */
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getCity());
			pstmt.setDouble(3, employee.getSalary());
			
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return status; 
	}
	
	public default List<Employee> getAll(Connection con){
		String query="select * from employee";
		List<Employee> list = new ArrayList<>();
		/* To execute the query we need to prepare the statement */
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				//read the data row by row
				int id = rst.getInt("id"); //1
				String name=rst.getString("name");
				String city = rst.getString("city");
				double salary = rst.getDouble("salary");
				//save these values in the obj 
				Employee e = new Employee(); //200X
				e.setId(id);
				e.setName(name);
				e.setCity(city);
				e.setSalary(salary);
				list.add(e);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list; 
	}
	
	public default boolean getById(int id,Connection con){
		String query="select * from employee where id=?";
		/* To execute the query we need to prepare the statement */
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rst = pstmt.executeQuery();
			return rst.next(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false; 
	}
	
	public default int delete(int id,Connection con){
		int status = 0;
		String query="delete from employee where id=?";
		/* To execute the query we need to prepare the statement */
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status; 
	}
	
	public default int update(Employee employee,Connection con) {
		int status=0;
		String query="update employee SET name=?,city=?,salary=? where id=?";
		/* To execute the query we need to prepare the statement */
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getCity());
			pstmt.setDouble(3, employee.getSalary());
			pstmt.setInt(4, employee.getId());
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status; 
	}
}














