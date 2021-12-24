package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Miscellaneous;
import com.revature.util.ConnectionFactory;

public class MiscellaneousDAO {
	
	public List<Miscellaneous> getMiscellaneous() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String misc = "SELECT * FROM misc;";
			//String misc = "SELECT misc_info, misc_cost, employees.f_name , employees.l_name FROM misc LEFT JOIN employees ON misc.reference_id = employees.employee_id; ";
			
			//put the SQL query into a statemnt object (The connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(misc);
			
			//ALL the code above, make a call to the database, now we need to store the date in an ArrayList
			
			//Create an empty List to be killed with the data from the database
			List<Miscellaneous> miscList = new ArrayList<>();
			
			//while there are results in the ResultSet
			while(rs.next()) {
				//Use the all args constructor to create a new Employee object from each returned row from the database
				Miscellaneous m = new Miscellaneous(
						//We want to use rs.get for each column in the record
						rs.getString("f_name"),
						rs.getString("l_name"),	
						rs.getString("misc_cost"),
						rs.getString("misc_info")				
						);
				//and populate the ArrayList with each new Employee Object				
				miscList.add(m);//e is the new Employee object we created above
			}
			
			//when there are no more results in rs, the while loop will break
			//finally we will return the ArrayList of employees
			return miscList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Miscellaneous");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block so Java wont yell. Because we cant make sure the try block will run
		
		
	}   

	public void submitMiscellaneous(Miscellaneous newMiscellaneous) {//This is INSERT functinoality
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			//well create a SQL statement using parameters to insert a new employee
			String misc = "INSERT INTO misc (f_name, l_name, misc_cost,  misc_info ) " //creating a line break for readability
						+ "VALUES (?,?,?,?); "; //these are parameters!!! we have to specify the values of each "?"
			
			PreparedStatement ps = conn.prepareStatement(misc);//we use PreparedStatements for SQL commands with variables
			
			//Use the Preparedstatemnt objects method to insert values into query;s ?s
			//the valuse will come from the Miscellaneous object we send in
			ps.setString(1, newMiscellaneous.getF_name());
			ps.setString(2, newMiscellaneous.getL_name());
			ps.setString(3, newMiscellaneous.getMisc_cost());
			ps.setString(4, newMiscellaneous.getMisc_info());


			//this executeUpdate() method actually sends and executes the SQL command we built in
			ps.executeUpdate();//we use executeUpdate() for inserts, updates, and deletes
			//we use executeQuery() for selects
			
			//send confirmation to the console if successful
			System.out.println("Miscellaneous Information Sucessfully Inputted");		
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Miscellaneous information");
			e.printStackTrace();
		}
	}



}
