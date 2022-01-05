package com.revature.services;

import java.util.List;

import com.revature.models.Lodging;
import com.revature.repositories.LodgingDAO;

public class LodgingService {
	
	LodgingDAO lDAO = new LodgingDAO();//So that I can use the method sform the employeeDAO

	public List<Lodging> getLodging() {
		return lDAO.getLodging();
	}
	public List<Lodging> getSingleLodging() {
		return lDAO.getSingleLodging();
	}
	public List<Lodging> getEmployeeLodging(int e_id) {
		return lDAO.getEmployeeLodging(e_id);
	}
	public void submitLodging(Lodging newLodging) {
		lDAO.submitLodging(newLodging);
	}	
	public void updateLodgingStatus(Lodging Lodging) {
		lDAO.updateLodgingStatus(Lodging);
	}
	public void updateLodgingStatus(int decision, int lodging_id) {
		lDAO.updateLodgingStatus(decision, lodging_id);
		
	}
}
