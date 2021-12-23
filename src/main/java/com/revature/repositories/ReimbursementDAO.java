package com.revature.repositories;
import com.revature.models.Employee;
import com.revature.models.Lodging;
import com.revature.models.Miscellaneous;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.Travel;
import com.revature.models.Food;
import com.revature.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	return null;
    }
    
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
    
public List<Travel> getTravel() { //This will use SQL SELECT functionality
	
	try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
		
		//Initialize an empty ResultSet object that will store the results of our SQL query
		ResultSet rs = null;
		
		//write the query that we want to send to the database, and assign it to a String
		String travel = "SELECT * FROM travel;";
		
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
					rs.getInt("travel_id"),
					rs.getString("travel_info"),
					rs.getString("travel_cost"),
					rs.getInt("employee_id")								
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
    
    
public List<Miscellaneous> getMiscellaneous() { //This will use SQL SELECT functionality
	
	try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
		
		//Initialize an empty ResultSet object that will store the results of our SQL query
		ResultSet rs = null;
		
		//write the query that we want to send to the database, and assign it to a String
		String misc = "SELECT * FROM misc;";
		
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
					rs.getInt("misc_id"),
					rs.getString("misc_info"),
					rs.getString("misc_cost"),
					rs.getInt("employee_id")								
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
					rs.getInt("empolyee_id"),
					rs.getString("f_name"),
					rs.getString("l_name"),
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
    
}
