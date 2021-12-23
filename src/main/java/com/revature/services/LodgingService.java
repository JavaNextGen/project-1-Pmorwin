package com.revature.services;

import com.revature.models.Lodging;
import com.revature.repositories.LodgingDAO;

public class LodgingService {
	
	LodgingDAO lDAO = new LodgingDAO();//So that I can use the method sform the employeeDAO

	public void inputLodging(Lodging newLodging) {
		
		//Take in the employee object sent from the menu and send it to the employee dao to be inserted into the database 
		
		
		//we need to call the DAO method that inserts the new Employee
		lDAO.submitLodging(newLodging);
		
	}	
}
