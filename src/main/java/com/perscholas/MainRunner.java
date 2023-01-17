package com.perscholas;

import com.perscholas.service.EmployeeService;

public class MainRunner {

	public static void main(String[] args) {
	
			EmployeeService es = new EmployeeService();
			
			System.out.println(es.getAllEmployees());
	}

}
