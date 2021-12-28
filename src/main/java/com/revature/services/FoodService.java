package com.revature.services;

import com.revature.models.Food;
import com.revature.repositories.FoodDAO;

public class FoodService {
	FoodDAO fDAO = new FoodDAO();//So that I can use the method sform the employeeDAO

	public void inputFood(Food newFood) {
		
		//Take in the employee object sent from the menu and send it to the employee dao to be inserted into the database 
		
		
		//we need to call the DAO method that inserts the new Employee
		fDAO.submitFood(newFood);
		
	}	
	public void updateFood(int decision, int food_id) {
		
		fDAO.updateFoodStatus(decision, food_id);
		
	}

}
