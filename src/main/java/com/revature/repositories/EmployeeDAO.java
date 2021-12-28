package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDAO {

	public List<Employee> getEmployees() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String sql = "SELECT * FROM employees;";
			
			//put the SQL query into a statemnt object (The connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(sql);
			
			//ALL the code above, make a call to the database, now we need to store the date in an ArrayList
			
			//Create an empty List to be killed with the data from the database
			List<Employee> employeeList = new ArrayList<>();
			
			//while there are results in the ResultSet
			while(rs.next()) {
				//Use the all args constructor to create a new Employee object from each returned row from the database
				Employee e = new Employee(
						//We want to use rs.get for each column in the record
						rs.getInt("e_id"),
						rs.getString("company_email"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("employee_username"),
						rs.getString("employee_password"),
						rs.getInt("role_id")
						);
				//and populate the ArrayList with each new Employee Object				
				employeeList.add(e);//e is the new Employee object we created above
			}
			
			//when there are no more results in rs, the while loop will break
			//finally we will return the ArrayList of employees
			return employeeList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Employees");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block so Java wont yell. Because we cant make sure the try block will run
		
		
	}    
	
	public void submitEmployee(Employee newEmployee) {//This is INSERT functinoality
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			//well create a SQL statement using parameters to insert a new employee
			String employee = "INSERT INTO employee (employee_id, company_email, f_name, l_name, employee_username, employee_password, role_id) " //creating a line break for readability
						+ "VALUES (DEFAULT,?,?,?,?,?,?); "; //these are parameters!!! we have to specify the values of each "?"
			
			PreparedStatement ps = conn.prepareStatement(employee);//we use PreparedStatements for SQL commands with variables
			
			//Use the Preparedstatemnt objects method to insert values into query;s ?s
			//the valuse will come from the Employee object we send in
			ps.setString(1,newEmployee.getCompany_email());
			ps.setString(2, newEmployee.getF_name());
			ps.setString(3, newEmployee.getL_name());
			ps.setString(4, newEmployee.getEmployee_username());
			ps.setString(5,newEmployee.getEmployee_password());
			ps.setInt(6, newEmployee.getRole_id());
			
			//this executeUpdate() method actually sends and executes the SQL command we built in
			ps.executeUpdate();//we use executeUpdate() for inserts, updates, and deletes
			//we use executeQuery() for selects
			
			//send confirmation to the console if successful
			System.out.println("Employee Information Sucessfully Inputted");
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Employee information");
			e.printStackTrace();
		}
	}
	
}




