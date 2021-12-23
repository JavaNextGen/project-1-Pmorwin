package com.revature.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Lodging;
import com.revature.util.ConnectionFactory;

public class LodgingDAO {
	
	public List<Lodging> getLodging() { //This will use SQL SELECT functionality
			
			try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
				
				//Initialize an empty ResultSet object that will store the results of our SQL query
				ResultSet rs = null;
				
				//write the query that we want to send to the database, and assign it to a String
				
				
				//String lod = "SELECT lodging_info, lodging_cost, employees.f_name , employees.l_name FROM lodging LEFT JOIN employees ON lodging.reference_id = employees.employee_id; ";
				String lod = "SELECT * FROM lodging;";	
				
				//put the SQL query into a statemnt object (The connection object has a method for this!!)
				Statement statement = conn.createStatement();
				
				//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
				//The statement object has a method that takes Strings to execute as a SQL query
				rs = statement.executeQuery(lod);
				
				//ALL the code above, make a call to the database, now we need to store the date in an ArrayList
				
				//Create an empty List to be killed with the data from the database
				List<Lodging> lodgingList = new ArrayList<>();
				
				//while there are results in the ResultSet
				while(rs.next()) {
					//Use the all args constructor to create a new Employee object from each returned row from the database
					Lodging l = new Lodging(
							//We want to use rs.get for each column in the record
							rs.getInt("lodging_id"),
							rs.getString("lodging_info"),
							rs.getString("lodging_cost"),
							rs.getInt("employee_id")								
							);
					//and populate the ArrayList with each new Employee Object				
					lodgingList.add(l);//e is the new Employee object we created above
				}
				
				//when there are no more results in rs, the while loop will break
				//finally we will return the ArrayList of employees
				return lodgingList;
			}
			catch(SQLException e){
				System.out.println("There was an error in selecting Lodging");
				e.printStackTrace();
			}
			
			return null; //we add this after the try/catch block so Java wont yell. Because we cant make sure the try block will run
			
			
		}
}
