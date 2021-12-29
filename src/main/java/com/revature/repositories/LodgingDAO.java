package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
					//Use the all args constructor to create a new Lodging object from each returned row from the database
					Lodging l = new Lodging(
							//We want to use rs.get for each column in the record
							rs.getInt("employee_id"),
							rs.getInt("lodging_id"),
							rs.getString("lodging_cost"),
							rs.getString("lodging_info")
												
							);
					//and populate the ArrayList with each new Lodging Object				
					lodgingList.add(l);//e is the new Lodging object we created above
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
	public List<Lodging> getSingleLodging() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String lod = "SELECT * FROM lodging WHERE status IS NULL LIMIT 1;";
			//String lod = "SELECT lodging_info, lodging_cost, employees.f_name , employees.l_name FROM lodging LEFT JOIN employees ON lodging.reference_id = employees.employee_id; ";
			
			
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
				//Use the all args constructor to create a new Lodging object from each returned row from the database
				Lodging l = new Lodging(
						//We want to use rs.get for each column in the record
						rs.getInt("employee_id"),
						rs.getInt("lodging_id"),
						rs.getString("lodging_cost"),
						rs.getString("lodging_info")
											
						);
				//and populate the ArrayList with each new Lodging Object				
				lodgingList.add(l);//e is the new Lodging object we created above
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
	public List<Lodging> getEmployeeLodging(int e_id) { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String lod = "SELECT * FROM lodging WHERE employee_id = ?;";
			//String food = "SELECT food_info, food_cost, employees.f_name , employees.l_name FROM food LEFT JOIN employees ON food.reference_id = employees.employee_id; ";
			
			//put the SQL query into a statemnt object (The connection object has a method for this!!)
			PreparedStatement ps = conn.prepareStatement(lod);//we use PreparedStatements for SQL commands with variables
			
			//Use the Preparedstatemnt objects method to insert values into query;s ?s
			//the valuse will come from the Food object we send in
			ps.setInt(1, e_id);
			
			
			//Statement statement = conn.createStatement();
			
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The statement object has a method that takes Strings to execute as a SQL query
			rs = ps.executeQuery();
			//rs = statement.executeQuery(lod);
			
			//ALL the code above, make a call to the database, now we need to store the date in an ArrayList
			
			//Create an empty List to be killed with the data from the database
			List<Lodging> lodgingList = new ArrayList<>();
			
			//while there are results in the ResultSet
			while(rs.next()) {
				//Use the all args constructor to create a new Lodging object from each returned row from the database
				Lodging l = new Lodging(
						//We want to use rs.get for each column in the record
						rs.getInt("employee_id"),
						rs.getInt("lodging_id"),
						rs.getString("lodging_cost"),
						rs.getString("lodging_info")
											
						);
				//and populate the ArrayList with each new Lodging Object				
				lodgingList.add(l);//e is the new Lodging object we created above
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
	public void submitLodging(Lodging newLodging) {//This is INSERT functinoality
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			//well create a SQL statement using parameters to insert a new employee
			String lodging = "INSERT INTO lodging (lodging_id, employee_id, lodging_cost, lodging_info) " //creating a line break for readability
						+ "VALUES (Default,?,?,?); "; //these are parameters!!! we have to specify the values of each "?"
			
			PreparedStatement ps = conn.prepareStatement(lodging);//we use PreparedStatements for SQL commands with variables
			
			
			//Use the Preparedstatemnt objects method to insert values into query;s ?s
			//the valuse will come from the Lodging object we send in
			ps.setInt(1, newLodging.getE_id());
			ps.setString(2, newLodging.getLodging_cost());
			ps.setString(3, newLodging.getLodging_info());



			//this executeUpdate() method actually sends and executes the SQL command we built in
			ps.executeUpdate();//we use executeUpdate() for inserts, updates, and deletes
			//we use executeQuery() for selects
			
			//send confirmation to the console if successful
			System.out.println("Lodging Information Sucessfully Inputted");	
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Lodging information");
			e.printStackTrace();
		}
	}
	public void updateLodgingStatus(int decision, int lodging_id) {
			
			try(Connection conn = ConnectionFactory.getConnection()){
				
				String lodging = "UPDATE lodging SET status = ? WHERE lodging_id = ?;";
				
				PreparedStatement ps = conn.prepareStatement(lodging);
				
				
				ps.setInt(1, decision);
				ps.setInt(2, lodging_id);
			
				
				ps.executeUpdate();
				
				System.out.println("The status of this request has been set to: " + decision);
				
			} catch (SQLException e) {
				System.out.println("Something went wrong during the update");
				e.printStackTrace();
			}
	}
	

	
}
