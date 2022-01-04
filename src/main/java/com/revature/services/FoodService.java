package com.revature.services;

import java.util.List;

import com.revature.models.Food;
import com.revature.repositories.FoodDAO;

public class FoodService {
	FoodDAO fDAO = new FoodDAO();//So that I can use the method sform the employeeDAO

	public List<Food> getFood() {
		return fDAO.getFood();
	}
	public List<Food> getSingleFood() {
		return fDAO.getSingleFood();
	}
	public List<Food> getEmployeeFood(int e_id) {
		return fDAO.getEmployeeFood(e_id);
	}
	public void submitFood(Food newFood) {
		fDAO.submitFood(newFood);	
	}	
	public void updateFoodStatus(int decision, int food_id) {
		fDAO.updateFoodStatus(decision, food_id);
	}

}
