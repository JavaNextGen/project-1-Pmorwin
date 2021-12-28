package com.revature.services;

import com.revature.models.Travel;
import com.revature.repositories.TravelDAO;

public class TravelService {
	TravelDAO tDAO = new TravelDAO();//So that I can use the method sform the employeeDAO

	public void inputTravel(Travel newTravel) {
		
		//Take in the employee object sent from the menu and send it to the employee dao to be inserted into the database 
		
		
		//we need to call the DAO method that inserts the new Employee
		tDAO.submitTravel(newTravel);
	}
	public void updateTravel(int decision, int e_id) {
		
		tDAO.updateTravelStatus(decision, e_id);
		
	}
	
}
