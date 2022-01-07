package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.AuthService;
import io.javalin.http.Handler;

public class AuthController {
	
	AuthService as = new AuthService();
	
	public Handler loginHandler = (ctx) -> {
		String body = ctx.body();
		Gson gson = new Gson();
		Employee Employee = gson.fromJson(body, Employee.class);
		System.out.println(Employee.getEmployee_username());
		System.out.println(Employee.getEmployee_password());
		if(as.login(Employee.getEmployee_username(),Employee.getEmployee_password())) {
			
			ctx.req.getSession();
			ctx.status(202);
			ctx.result("Login Successful!" );
		}
		else {
			ctx.status(401);
			ctx.result("Login Failed");
		}
		
		
	};

}
