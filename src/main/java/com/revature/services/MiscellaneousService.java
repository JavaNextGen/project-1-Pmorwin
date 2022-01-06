package com.revature.services;

import java.util.List;

import com.revature.models.Miscellaneous;
import com.revature.repositories.MiscellaneousDAO;

public class MiscellaneousService {
	MiscellaneousDAO mDAO = new MiscellaneousDAO();//So that I can use the method sform the employeeDAO

	public List<Miscellaneous> getMiscellaneous() throws Exception {
		List<Miscellaneous> result = mDAO.getMiscellaneous();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Miscellaneous> getSingleMiscellaneous() throws Exception {
		List<Miscellaneous> result = mDAO.getSingleMiscellaneous();
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public List<Miscellaneous> getEmployeeMiscellaneous(int e_id) throws Exception {
		List<Miscellaneous> result = mDAO.getEmployeeMiscellaneous(e_id);
		if(result.get(0).getE_id() != 0) {
			return result;
		}
		else {
			throw new Exception();
		}
	}
	public void submitMiscellaneous(Miscellaneous newMiscellaneous) throws Exception {
		int result = mDAO.submitMiscellaneous(newMiscellaneous);
		if(result == 0) {
			throw new Exception();
		}
	}	
	public void updateMiscellaneousStatus(Miscellaneous Miscellaneous) throws Exception {
		int result = mDAO.updateMiscStatus(Miscellaneous);
		if(result == 0) {
			throw new Exception();
		}
	}
	public void updateMiscellaneousStatus(int decision, int misc_id) throws Exception {
		int result = mDAO.updateMiscStatus(decision, misc_id);
		if(result == 0) {
			throw new Exception();
		}
	}
}
