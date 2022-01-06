package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Lodging;
import com.revature.services.LodgingService;
import io.javalin.http.Handler;

public class LodgingController {
	LodgingService ls = new LodgingService();

	public Handler getLodgingHandler = ctx ->{
		try { //checks if the session exists
			List<Lodging> Lodging = ls.getLodging();
			Gson gson = new Gson();
			String JSONLodging = gson.toJson(Lodging);
			
			ctx.result(JSONLodging);
			ctx.status(200);
		}
		catch(Exception e) {
			ctx.result("There was an error while fetching Lodging Requests");
			ctx.status(404);
		}
	};
	public Handler getSingleLodgingHandler = ctx ->{
		try { //checks if the session exists
			List<Lodging> Lodging = ls.getSingleLodging();
			Gson gson = new Gson();
			String JSONLodging = gson.toJson(Lodging);
			
			ctx.result(JSONLodging);
			ctx.status(200);
		}
		catch(Exception e) {
			ctx.result("There was an error while fetching Lodging Request");
			ctx.status(404);
		}
	};
	public Handler getEmployeeLodgingHandler = ctx -> {
		try{ 
			int e_id = Integer.parseInt(ctx.pathParam("e_id"));
			List<Lodging> Lodging = ls.getEmployeeLodging(e_id);
			Gson gson = new Gson();
			String JSONLodgings = gson.toJson(Lodging);
			
			ctx.result(JSONLodgings);
			ctx.status(200);
		}
		catch(Exception e) {
			ctx.result("There was an error while fetching Lodging Requests");
			ctx.status(404);
		}
	};
	public Handler submitLodgingHandler = (ctx) -> {
		try {
			String body = ctx.body();
			Gson gson = new Gson();
			Lodging Lodging = gson.fromJson(body, Lodging.class);
			ls.submitLodging(Lodging);
			
			ctx.result("Lodging was sucessfully added!");
			ctx.status(201);
		}
		catch(Exception e) {
			ctx.result("Failed to insert Lodging request");
			ctx.status(406);
		}
	};
	public Handler updateLodgingStatusHandler = ctx ->{
		try {
			String body = ctx.body();
			Gson gson = new Gson();
			Lodging Lodging = gson.fromJson(body, Lodging.class);			
			ls.updateLodgingStatus(Lodging);
			
			ctx.result("Lodging Status was sucessfully updated!");
			ctx.status(200);
		}
		catch(Exception e) {
			ctx.result("There was an error while updating Lodging Status");
			ctx.status(406);
		}
	};
}

