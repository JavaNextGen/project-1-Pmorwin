package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.models.AbstractUser;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDAO;


public class UserService {

	UserDAO ud = new UserDAO();


	public Optional<User> getByUsername(String username) {
		  User GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", Role.EMPLOYEE);
	        Optional<User> optional = Optional.of(GENERIC_EMPLOYEE_1);
		return optional;
	}
	
	
  }

