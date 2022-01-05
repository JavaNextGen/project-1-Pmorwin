package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Travel;
import com.revature.services.TravelService;
import io.javalin.http.Handler;

public class TravelController {
	TravelService ts = new TravelService();
	

	public Handler getTravelHandler = ctx ->{
		if(ctx.req.getSession(false) != null) { //checks if the session exists
			
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
	public Handler getSingleTravelHandler = ctx ->{
		if(ctx.req.getSession(false) != null) { //checks if the session exists
			
			List<Travel> Travel = ts.getSingleTravel();
			
			Gson gson = new Gson();
			
			String JSONTravel = gson.toJson(Travel);
			
			ctx.result(JSONTravel);
			ctx.status(200);
			
		}
		else {
			ctx.result("There was an error while fetching Travel Request");
			ctx.status(404);
		}
	};
	public Handler getEmployeeTravelHandler = ctx ->{
		if(ctx.req.getSession(false) != null) { //checks if the session exists
			
			int e_id = Integer.parseInt(ctx.pathParam("e_id"));
			
			List<Travel> Travel = ts.getEmployeeTravel(e_id);
			
			Gson gson = new Gson();
			
			String JSONTravels = gson.toJson(Travel);
			
			ctx.result(JSONTravels);
			ctx.status(200);
			
		}
		else {
			ctx.result("There was an error while fetching Travel Requests");
			ctx.status(404);
		}
	};
	public Handler submitTravelHandler = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Travel Travel = gson.fromJson(body, Travel.class);
			
			ts.submitTravel(Travel);
			
			ctx.result("Travel was sucessfully added!");
			ctx.status(201);
		}
		else {
			ctx.result("Failed to insert Travel request");
			ctx.status(406);
		}
			
	
	};
	public Handler updateTravelStatusHandler = ctx ->{
		if(ctx.req.getSession(false) != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Travel Travel = gson.fromJson(body, Travel.class);
					
			ts.updateTravelStatus(Travel);
			
			ctx.result("Travel Status was sucessfully updated!");
			ctx.status(200);
		}
		else {
			ctx.result("There was an error while updating Travel Status");
			ctx.status(406);
		}
	};
}
