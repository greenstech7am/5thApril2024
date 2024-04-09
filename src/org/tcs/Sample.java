package org.tcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample {
	
	
	public static void main(String[] args) {
		
		Connection con=null;
		
		// 1. Load the driver
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.Connect to database
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
		
		//3.Write a SQL query
		String query = "select * from student";
		
		//4. Prepare the statement
		PreparedStatement ps = con.prepareStatement(query);
		
		//5. execute query
		ResultSet rs = ps.executeQuery();
		
		//6. Iterate the results
		while (rs.next()) {
			
			int stuId = rs.getInt("sid");
			System.out.println(stuId);
			String stuName = rs.getString("sname");
			System.out.println(stuName);
				
		}
		
		
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		
		//7. Close the db connection
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Hello");
			System.out.println("Kannan cloned");
			System.out.println("Hello Good Morning - Kannan added");
		}
		
		
		
	}
		
		
		
		
		
	}

}
