package com.revature.services;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;

public class EmployeeService {

	EmployeeDAO eDAO = new EmployeeDAO();//So that I can use the method sform the employeeDAO

	public void getEmployees() {
		eDAO.getEmployees();
	}
	public void submitEmployee(Employee newEmployee) {
		eDAO.submitEmployee(newEmployee);
	}	

}