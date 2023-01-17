package com.perscholas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		// connection info
		 final String DB_URL = "jdbc:mariadb://localhost:3306/classicmodels";
		 final String USER = "root";
		 final String PASS = "root";
		 final String QUERY = "SELECT * FROM employees where employeeNumber = ?";

		 // connection 
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); ){
			System.out.println(conn.isValid(0)); 
			
			// ps to talk to db
			PreparedStatement ps = conn.prepareStatement(QUERY);
			ps.setInt(1, 1702);
			// catch the result 
			ResultSet rs = ps.executeQuery();
			ps.close();
			rs.close();
			
			// print the result
			while(rs.next()) {
				
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString("email"));
			
				
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
