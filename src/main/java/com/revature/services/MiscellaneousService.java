package com.revature.services;

import java.util.List;

import com.revature.models.Miscellaneous;
import com.revature.repositories.MiscellaneousDAO;

public class MiscellaneousService {
	MiscellaneousDAO mDAO = new MiscellaneousDAO();//So that I can use the method sform the employeeDAO

	public List<Miscellaneous> getMiscellaneous() {
		return mDAO.getMiscellaneous();
	}
	public List<Miscellaneous> getSingleMiscellaneous() {
		return mDAO.getSingleMiscellaneous();
	}
	public List<Miscellaneous> getEmployeeMiscellaneous(int e_id) {
		return mDAO.getEmployeeMiscellaneous(e_id);
	}
	public void submitMiscellaneous(Miscellaneous newMiscellaneous) {
		mDAO.submitMiscellaneous(newMiscellaneous);
	}	
	public void updateMisc(int decision, int misc_id) {
		mDAO.updateMiscStatus(decision, misc_id);
	}
}
