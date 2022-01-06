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
	
	public Handler getEmployeeRequestHandler = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			try { 
				int e_id = Integer.parseInt(ctx.pathParam("e_id"));		
				//Lodging
				List<Lodging> Lodging = ls.getEmployeeLodging(e_id);
				Gson lgson = new Gson();
				String JSONLodgings = lgson.toJson(Lodging);
				//Travel
				List<Travel> Travel = ts.getEmployeeTravel(e_id);
				Gson tgson = new Gson();
				String JSONTravel = tgson.toJson(Travel);
				//Food
				List<Food> Food = fs.getEmployeeFood(e_id);
				Gson fgson = new Gson();
				String JSONFoods = fgson.toJson(Food);	
				//Miscellaneous
				List<Miscellaneous> Miscellaneous = ms.getEmployeeMiscellaneous(e_id);
				Gson mgson = new Gson();
				String JSONMiscellaneous = mgson.toJson(Miscellaneous);
				String JCC = JSONLodgings.concat(JSONTravel).concat(JSONFoods).concat(JSONMiscellaneous);
				ctx.result(JCC);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching this Employees Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
	public Handler submitEmployeeHandler = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			try {
				String body = ctx.body();
				Gson gson = new Gson();
				Employee employee = gson.fromJson(body, Employee.class);
				es.submitEmployee(employee);
				ctx.result("Employee was successfully added!");
				ctx.status(201);
			}
			catch(Exception e) {
				ctx.result("Failed to insert employees");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);
		}
	};
}
