package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu_Employee;
import com.revature.models.Menu_Manager;
import com.revature.util.ConnectionFactory;

public class Driver {

	public static void main(String[] args) {
		
		//Testing Database Connectivity - just testing whether our connection (from ConnectionFactory) is sucessful
		
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful! :)");
		}
		catch(SQLException e) {
			System.out.println("Connection Unsuccessful! :(");
			e.printStackTrace();
		}
		

		//Instantiate a employee menu object
		Menu_Employee e_menu = new Menu_Employee();
		//Instantiate a manager upgrade menu object
		Menu_Manager m_menu = new Menu_Manager();	
		
		
		//Here is the actual functionality of our application---------------------------------------------
		Boolean Starter = true;
	
		if (Starter) {
		e_menu.displayMenu();
		}
		else {		
		m_menu.displayMenu();
		}
		
		
		
		
	}
}
