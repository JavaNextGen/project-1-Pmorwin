package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;

public class EmployeeService {

	EmployeeDAO eDAO = new EmployeeDAO();//So that I can use the method sform the employeeDAO

	public List<Employee> getEmployees() throws Exception {
		List<Employee> result = eDAO.getEmployees();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public void submitEmployee(Employee newEmployee) throws Exception {
		int result = eDAO.submitEmployee(newEmployee);
		if(result == 0) {
			throw new Exception();
		}
	}	

}