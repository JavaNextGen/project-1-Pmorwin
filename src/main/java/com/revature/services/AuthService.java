package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.repositories.EmployeeDAO;

import io.javalin.core.util.JavalinException;


public class AuthService {
	EmployeeDAO ed = new EmployeeDAO();
		
    /**
     * <ul>
     *     <li>Needs to check for existing users with username/email provided.</li>
     *     <li>Must throw exception if user does not exist.</li>
     *     <li>Must compare password provided and stored password for that user.</li>
     *     <li>Should throw exception if the passwords do not match.</li>
     *     <li>Must return user object if the user logs in successfully.</li>
     * </ul>
     * @throws Exception 
     */
    public boolean login(String username, String password) {   
    	List<Employee> CheckUsername = ed.loginRequest(username, password);
    	try{
    		Employee Check = CheckUsername.get(0);
    		String Username = Check.getEmployee_username();
        	String Password = Check.getEmployee_password();
            if (Username.equals(username) && Password.equals(password)) {
            	return true;
            	
            }
            else {
            	return false;
            }
    	}
    	catch(IndexOutOfBoundsException e) {
    		System.out.println("That Username or Password didn't match our system");
    		return false;
    	}
    	
    }
    public Optional<Employee> exampleRetrieveCurrentEmployee() {
        return Optional.empty();
    }


	public Object register(User eMPLOYEE_TO_REGISTER) {
		// TODO Auto-generated method stub
		return null;
	}
}
