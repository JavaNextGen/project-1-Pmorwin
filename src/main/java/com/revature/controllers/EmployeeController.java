package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.models.Food;
import com.revature.models.Lodging;
import com.revature.models.Miscellaneous;
import com.revature.models.Travel;
import com.revature.services.EmployeeService;
import com.revature.services.FoodService;
import com.revature.services.LodgingService;
import com.revature.services.MiscellaneousService;
import com.revature.services.TravelService;

import io.javalin.http.Handler;

public class EmployeeController {
	EmployeeService es = new EmployeeService();
	FoodService fs = new FoodService();
	LodgingService ls = new LodgingService();
	MiscellaneousService ms = new MiscellaneousService();
	TravelService ts = new TravelService();

	
	
	public Handler getEmployeeHandler = (ctx) -> {
		//Gets the Employee's Food Requests
		if(ctx.req.getSession(false) != null) { //checks if the session exists
					
					int e_id = Integer.parseInt(ctx.pathParam("e_id"));
					
					
					//Food
					List<Food> Food = fs.getEmployeeFood(e_id);
					Gson fgson = new Gson();
					String JSONFoods = fgson.toJson(Food);
					
					//Lodging
					List<Lodging> Lodging = ls.getEmployeeLodging(e_id);
					Gson lgson = new Gson();
					String JSONLodgings = lgson.toJson(Lodging);
					
					//Miscellaneous
					List<Miscellaneous> Miscellaneous = ms.getEmployeeMiscellaneous(e_id);
					Gson mgson = new Gson();
					String JSONMiscellaneouss = mgson.toJson(Miscellaneous);
					
					//Travel
					List<Travel> Travel = ts.getTravel();
					Gson gson = new Gson();
					String JSONTravel = gson.toJson(Travel);
					
					
//					ctx.result(JSONTravel);
//					ctx.result(JSONMiscellaneouss);
//					ctx.result(JSONLodgings);
					ctx.result(JSONFoods + JSONTravel + JSONMiscellaneouss + JSONLodgings);
					ctx.status(200);
					
				}
				else {
					ctx.result("There was an error while fetching Food Requests");
					ctx.status(404);
				}
		//Gets the Employee's Lodging Requests
		if(ctx.req.getSession() != null) { //checks if the session exists
					
					int e_id = Integer.parseInt(ctx.pathParam("e_id"));
					
					List<Lodging> Lodging = ls.getEmployeeLodging(e_id);
					
					Gson gson = new Gson();
					
					String JSONLodgings = gson.toJson(Lodging);
					
					ctx.result(JSONLodgings);
					ctx.status(200);
					
				}
				else {
					ctx.result("There was an error while fetching Lodging Requests");
					ctx.status(404);
				}
		//Gets the Employee's Miscellaneous Requests
		if(ctx.req.getSession() != null) { //checks if the session exists
					
					int e_id = Integer.parseInt(ctx.pathParam("e_id"));
					
					List<Miscellaneous> Miscellaneous = ms.getEmployeeMiscellaneous(e_id);
					
					Gson gson = new Gson();
					
					String JSONMiscellaneouss = gson.toJson(Miscellaneous);
					
					ctx.result(JSONMiscellaneouss);
					ctx.status(200);
					
				}
				else {
					ctx.result("There was an error while fetching Miscellaneous Requests");
					ctx.status(404);
				}
		//Gets the Employee's Travel Requests
		if(ctx.req.getSession() != null) { //checks if the session exists
					
					List<Travel> Travel = ts.getTravel();
					
					Gson gson = new Gson();
					
					String JSONTravel = gson.toJson(Travel);
					
					ctx.result(JSONTravel);
					ctx.status(200);
					
				}
				else {
					ctx.result("There was an error while fetching Travel Requests");
					ctx.status(404);
				}
	
	};
	public Handler submitEmployeeHandler = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Employee employee = gson.fromJson(body, Employee.class);
			
			es.submitEmployee(employee);
			
			ctx.result("Employee was successfully added!");
			ctx.status(201);
		}
		else {
			ctx.result("Failed to insert employees");
			ctx.status(406);
		}
			
	
	};
	
	
	
	
	
	
	
}
