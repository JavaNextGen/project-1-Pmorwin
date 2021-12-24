package com.revature.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
			//String food = "SELECT food_info, food_cost, employees.f_name , employees.l_name FROM food LEFT JOIN employees ON food.reference_id = employees.employee_id; ";
			
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
						rs.getString("f_name"),
						rs.getString("l_name"),	
						rs.getString("food_cost"),
						rs.getString("food_info")							
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
	public void submitFood(Food newFood) {//This is INSERT functinoality
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			//well create a SQL statement using parameters to insert a new employee
			String food = "INSERT INTO food (f_name, l_name, food_cost, food_info) " //creating a line break for readability
						+ "VALUES (?,?,?,?); "; //these are parameters!!! we have to specify the values of each "?"
			
			PreparedStatement ps = conn.prepareStatement(food);//we use PreparedStatements for SQL commands with variables
			
			//Use the Preparedstatemnt objects method to insert values into query;s ?s
			//the valuse will come from the Food object we send in
			ps.setString(1, newFood.getF_name());
			ps.setString(2, newFood.getL_name());
			ps.setString(3, newFood.getFood_cost());
			ps.setString(4, newFood.getFood_info());

			//this executeUpdate() method actually sends and executes the SQL command we built in
			ps.executeUpdate();//we use executeUpdate() for inserts, updates, and deletes
			//we use executeQuery() for selects
			
			//send confirmation to the console if successful
			System.out.println("Food Information Sucessfully Inputted");
		}
		catch(SQLException e) {
			System.out.println("There was an error while attempting to input Food information");
			e.printStackTrace();
		}
	}    
	    
}
