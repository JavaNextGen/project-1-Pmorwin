package com.revature.services;

import com.revature.models.Miscellaneous;
import com.revature.repositories.MiscellaneousDAO;

public class MiscellaneousService {
	MiscellaneousDAO mDAO = new MiscellaneousDAO();//So that I can use the method sform the employeeDAO

	public void inputMiscellaneous(Miscellaneous newMiscellaneous) {
		
		//Take in the employee object sent from the menu and send it to the employee dao to be inserted into the database 
		
		
		//we need to call the DAO method that inserts the new Employee
		mDAO.submitMiscellaneous(newMiscellaneous);
		
	}	
	public void updateMisc(int decision, int e_id) {
		
		mDAO.updateMiscStatus(decision, e_id);
		
	}
}
