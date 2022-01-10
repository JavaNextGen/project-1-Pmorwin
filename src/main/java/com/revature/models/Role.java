package com.revature.models;

/**
 * Users within the ERS application are categorized within the following roles:
 * <ul>
 *     <li>Employee</li>
 *     <li>Finance Manager</li>
 * </ul>
 *
 * Employees are the standard role for Users within the application.
 *
 * Finance Managers have additional permissions to process reimbursement requests.
 * <ul>
 *     <li>Finance Managers can submit reimbursement requests</li>
 *     <li>Finance Managers cannot process their own requests</li>
 * </ul>
 *
 * @author Center of Excellence
 */
public enum Role {

    EMPLOYEE {
        @Override
        public int Employee() {
            return 1;
        }
    },
    FINANCE_MANAGER {
        @Override
        public int Finance_Manager() {
            return 2;
        }
    };

	public int Employee() {
		// TODO Auto-generated method stub
		return 1;
	}

	public int Finance_Manager() {
		// TODO Auto-generated method stub
		return 2;
	}

}
