package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu_Employee;
import com.revature.util.ConnectionFactory;

public class Driver {

	public static void main(String[] args) {
		
		//Testing Database Connectivity - just testing whether our connection (from ConnectionFactory) is sucessful
		
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful! :)");
		}
		catch(SQLException e) {
			System.out.println("Gosh Darnnit");
			e.printStackTrace();
		}
		
		
		//Here is the actual functionality of our application---------------------------------------------
		//spoiler alert... there will only be two lines of code here 		
		
		//Instantiate a menu object
		Menu_Employee menu = new Menu_Employee();
		//Use the menu Classes displayMenu() to give the user the menu
		menu.displayMenu();
		//This is our entire main method (until we learn Javalin in week 4)
	
		//All of the complicated menu logic is hidden in the menu class... This is the power of abstractionhi
		
	}
}
