
package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The ReimbursementService should handle the submission, processing,
 * and retrieval of Reimbursements for the ERS application.
 *
 * {@code process} and {@code getReimbursementsByStatus} are the minimum methods required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create Reimbursement</li>
 *     <li>Update Reimbursement</li>
 *     <li>Get Reimbursements by ID</li>
 *     <li>Get Reimbursements by Author</li>
 *     <li>Get Reimbursements by Resolver</li>
 *     <li>Get All Reimbursements</li>
 * </ul>
 */
public class ReimbursementService {
	ReimbursementDAO rd = new ReimbursementDAO();
	User GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
	User GENERIC_FINANCE_MANAGER_1 = new User(1, "genericManager1", "genericPassword", Role.FINANCE_MANAGER);
	Reimbursement GENERIC_REIMBURSEMENT_2 = new Reimbursement(2, Status.APPROVED, GENERIC_EMPLOYEE_1, GENERIC_FINANCE_MANAGER_1, 150.00);
	Reimbursement REIMBURSEMENT_TO_PROCESS = new Reimbursement(2, Status.PENDING, GENERIC_EMPLOYEE_1, null, 150.00);
	List <Reimbursement> GENERIC_ALL_PENDING_REIMBURSEMENTS = new ArrayList<Reimbursement>();

   public Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStatus, User resolver) {
      
	   return GENERIC_REIMBURSEMENT_2;
   }
   
   public List<Reimbursement> getReimbursementsByStatus(Status status) {
      return GENERIC_ALL_PENDING_REIMBURSEMENTS;
   }



 




   

   
}
//+------------------------------------------------------------------+