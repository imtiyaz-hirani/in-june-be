package com.mymavenapp.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface BaseRepository {
	public String url="jdbc:mysql://localhost:3306/in_june_be";
	public String dbUser = "root";
	public String dbPassword = "";
	public String driver="com.mysql.cj.jdbc.Driver";
	
	public default Connection dbConnect() {
		/* Step 1: Load the driver */
		try {
			Class.forName(driver);
			//System.out.println("Driver Loaded...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/* Step 2: Establish Connection and return Connection ref.  */
		
		try {
			Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
			//System.out.println("Connection established");
			return con; 
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public default void dbClose(Connection con) {
		try {
			con.close();
			//System.out.println("connection closed..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}