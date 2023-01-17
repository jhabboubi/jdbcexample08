package com.perscholas.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.dao.EmployeeDAO;
import com.perscholas.dto.EmployeeDTO;
import com.perscholas.models.Employees;

public class EmployeeService implements EmployeeDAO{
	
	 static final String DB_URL = "jdbc:mariadb://localhost:3306/classicmodels";
	 static final String USER = "root";
	 static final String PASS = "root";
	

	@Override
	public int createEmployee(Employees employees) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employees> getAllEmployees() {
		
		List<Employees> listEmp = new ArrayList<>();
		// connection 
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); ){
			
			// prepared statement 
				PreparedStatement ps = conn.prepareStatement("select * from employees");
			// result set 
				ResultSet rs = ps.executeQuery();
			// convert result set to employee object
				while(rs.next()) {
					
					//int employeeNumber, String lastName, String firstName, String extension, String email,
					// String officeCode, int reportsTo, String jobTitle, int vacationHours
					Employees e =new Employees(
							rs.getInt("employeeNumber"),
							rs.getString("lastName"),
							rs.getString("firstName"),
							rs.getString("extension"),
							rs.getString("email"),
							rs.getString("officeCode"),
							rs.getInt("reportsTo"),
							rs.getString("jobTitle"),
							rs.getInt("VacationHours")
							
							);
					// add object into list 
					listEmp.add(e);
				
				}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		return listEmp;
	}

	@Override
	public int updateEmployee(Employees employees) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<EmployeeDTO> getEmployeeEmails(){
		
		List<EmployeeDTO> listEmp = new ArrayList<>();
		// connection 
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS); ){
			
			// prepared statement 
				PreparedStatement ps = conn.prepareStatement("select * from employees");
			// result set 
				ResultSet rs = ps.executeQuery();
			// convert result set to employee object
				while(rs.next()) {
					
					//int employeeNumber, String lastName, String firstName, String extension, String email,
					// String officeCode, int reportsTo, String jobTitle, int vacationHours
					EmployeeDTO e =new EmployeeDTO(
							rs.getInt("employeeNumber"),
							rs.getString("email")
							);
					// add object into list 
					listEmp.add(e);
				
				}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		return listEmp;
		
	}

}
