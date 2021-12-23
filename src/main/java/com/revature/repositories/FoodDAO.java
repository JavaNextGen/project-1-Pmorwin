package com.revature.repositories;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Food;
import com.revature.util.ConnectionFactory;

public class FoodDAO {
	
	public List<Food> getFood() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String food = "SELECT * FROM food;";
			
			//put the SQL query into a statemnt object (The connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(food);
			
			//ALL the code above, make a call to the database, now we need to store the date in an ArrayList
			
			//Create an empty List to be killed with the data from the database
			List<Food> foodList = new ArrayList<>();
			
			//while there are results in the ResultSet
			while(rs.next()) {
				//Use the all args constructor to create a new Employee object from each returned row from the database
				Food f = new Food(
						//We want to use rs.get for each column in the record
						rs.getInt("food_id"),
						rs.getString("food_info"),
						rs.getString("food_cost"),
						rs.getInt("employee_id")								
						);
				//and populate the ArrayList with each new Employee Object				
				foodList.add(f);//e is the new Employee object we created above
			}
			
			//when there are no more results in rs, the while loop will break
			//finally we will return the ArrayList of employees
			return foodList;
		}
		catch(SQLException e){
			System.out.println("There was an error in selecting Food");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block so Java wont yell. Because we cant make sure the try block will run
		
		
	}   
	    
	    
}
