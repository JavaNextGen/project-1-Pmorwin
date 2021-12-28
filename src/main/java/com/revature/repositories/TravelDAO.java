package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Travel;
import com.revature.util.ConnectionFactory;

public class TravelDAO {
	public List<Travel> getTravel() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String travel = "SELECT * FROM travel;";
			//String travel = "SELECT travel_info, travel_cost, employees.f_name , employees.l_name FROM travel LEFT JOIN employees ON travel.reference_id = employees.employee_id; ";
			
			//put the SQL query into a statemnt object (The connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(travel);
			
			//ALL the code above, make a call to the database, now we need to store the date in an ArrayList
			
			//Create an empty List to be killed with the data from the database
			List<Travel> travelList = new ArrayList<>();
			
			//while there are results in the ResultSet
			while(rs.next()) {
				//Use the all args constructor to create a new Employee object from each returned row from the database
				Travel t = new Travel(
						//We want to use rs.get for each column in the record
						rs.getInt("employee_id"),
						rs.getInt("travel_id"),
						rs.getString("travel_cost"),
						rs.getString("travel_info")							
						);
				//and populate the ArrayList with each new Employee Object				
				travelList.add(t);//e is the new Employee object we created above
			}
			
			//when there are no more results in rs, the while loop will break
			//finally we will return the ArrayList of employees
			return travelList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Travel");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block so Java wont yell. Because we cant make sure the try block will run
		
		
	}
	public List<Travel> getSingleTravel() { //This will use SQL SELECT functionality
			
			try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
				
				//Initialize an empty ResultSet object that will store the results of our SQL query
				ResultSet rs = null;
				
				//write the query that we want to send to the database, and assign it to a String
				String travel = "SELECT * FROM travel WHERE status IS NULL LIMIT 1;";
				//String travel = "SELECT travel_info, travel_cost, employees.f_name , employees.l_name FROM travel LEFT JOIN employees ON travel.reference_id = employees.employee_id; ";
				
				//put the SQL query into a statemnt object (The connection object has a method for this!!)
				Statement statement = conn.createStatement();
				
				//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
				//The statement object has a method that takes Strings to execute as a SQL query
				rs = statement.executeQuery(travel);
				
				//ALL the code above, make a call to the database, now we need to store the date in an ArrayList
				
				//Create an empty List to be killed with the data from the database
				List<Travel> travelList = new ArrayList<>();
				
				//while there are results in the ResultSet
				while(rs.next()) {
					//Use the all args constructor to create a new Employee object from each returned row from the database
					Travel t = new Travel(
							//We want to use rs.get for each column in the record
							rs.getInt("employee_id"),
							rs.getInt("travel_id"),
							rs.getString("travel_cost"),
							rs.getString("travel_info")							
							);
					//and populate the ArrayList with each new Employee Object				
					travelList.add(t);//e is the new Employee object we created above
				}
				
				//when there are no more results in rs, the while loop will break
				//finally we will return the ArrayList of employees
				return travelList;
			}
			catch(SQLException e){
				System.out.println("There was an error in selecting Travel");
				e.printStackTrace();
			}
			
			return null; //we add this after the try/catch block so Java wont yell. Because we cant make sure the try block will run
			
			
		}
	public void submitTravel(Travel newTravel) {//This is INSERT functinoality
	
		try(Connection conn = ConnectionFactory.getConnection()){
			
			//well create a SQL statement using parameters to insert a new employee
			String travel = "INSERT INTO travel (employee_id, travel_cost, travel_info) " //creating a line break for readability
						+ "VALUES (?,?,?); "; //these are parameters!!! we have to specify the values of each "?"
			
			PreparedStatement ps = conn.prepareStatement(travel);//we use PreparedStatements for SQL commands with variables
			
			//Use the Preparedstatemnt objects method to insert values into query;s ?s
			//the valuse will come from the Travel object we send in
			ps.setInt(1, newTravel.getE_id());
			ps.setString(2, newTravel.getTravel_cost());
			ps.setString(3, newTravel.getTravel_info());


			//this executeUpdate() method actually sends and executes the SQL command we built in
			ps.executeUpdate();//we use executeUpdate() for inserts, updates, and deletes
			//we use executeQuery() for selects
			
			//send confirmation to the console if successful
			System.out.println("Travel Information Sucessfully Inputted");
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Travel information");
			e.printStackTrace();
		}
	}
	public void updateTravelStatus(int decision, int travel_id) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String travel = "UPDATE travel SET status = ? WHERE travel_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(travel);
			
			
			ps.setInt(1, decision);
			ps.setInt(2, travel_id);
			
			ps.executeUpdate();
			
			System.out.println("The status of this request has been set to: " + decision);
			
		} catch (SQLException e) {
			System.out.println("Something went wrong during the update");
			e.printStackTrace();
		}
	}

}
