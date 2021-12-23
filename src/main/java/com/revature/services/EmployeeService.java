package com.revature.services;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;

public class EmployeeService {

	EmployeeDAO eDAO = new EmployeeDAO();//So that I can use the method sform the employeeDAO

	public void addEmployee(Employee newEmployee) {
		
		//Take in the employee object sent from the menu and send it to the employee dao to be inserted into the database 
		
		
		//we need to call the DAO method that inserts the new Employee
		eDAO.submitEmployee(newEmployee);
		
	}	
}