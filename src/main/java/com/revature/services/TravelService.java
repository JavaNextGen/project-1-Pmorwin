package com.revature.services;

import java.util.List;

import com.revature.models.Travel;
import com.revature.repositories.TravelDAO;

public class TravelService {
	TravelDAO tDAO = new TravelDAO();//So that I can use the method sform the employeeDAO

	public List<Travel> getTravel() {
		return tDAO.getTravel();
	}
	public List<Travel> getSingleTravel() {
		return tDAO.getSingleTravel();
	}
	public List<Travel> getEmployeeTravel(int e_id) {
		return tDAO.getEmployeeTravel(e_id);
	}
	public void submitTravel(Travel newTravel) {
		tDAO.submitTravel(newTravel);
	}
	public void updateTravel(int decision, int travel_id) {
		tDAO.updateTravelStatus(decision, travel_id);
	}
	
}
