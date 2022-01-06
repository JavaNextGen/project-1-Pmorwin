package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Miscellaneous;
import com.revature.services.MiscellaneousService;
import io.javalin.http.Handler;

public class MiscellaneousController {
	MiscellaneousService ms = new MiscellaneousService();
	

	public Handler getMiscellaneousHandler = ctx ->{
		if(ctx.req.getSession(false) != null) {
			try {
				List<Miscellaneous> Miscellaneous = ms.getMiscellaneous();
				Gson gson = new Gson();
				String JSONMiscellaneous = gson.toJson(Miscellaneous);
				ctx.result(JSONMiscellaneous);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Miscellaneous Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
	public Handler getSingleMiscellaneousHandler = ctx ->{
		if(ctx.req.getSession(false) != null) {
			try {
				List<Miscellaneous> Miscellaneous = ms.getSingleMiscellaneous();
				Gson gson = new Gson();
				String JSONMiscellaneous = gson.toJson(Miscellaneous);
				ctx.result(JSONMiscellaneous);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Miscellaneous Request");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
	public Handler getEmployeeMiscellaneousHandler = ctx ->{
		if(ctx.req.getSession(false) != null) {
			try {
				int e_id = Integer.parseInt(ctx.pathParam("e_id"));
				List<Miscellaneous> Miscellaneous = ms.getEmployeeMiscellaneous(e_id);
				Gson gson = new Gson();
				String JSONMiscellaneouss = gson.toJson(Miscellaneous);
				ctx.result(JSONMiscellaneouss);
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while fetching Miscellaneous Requests");
				ctx.status(404);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
	public Handler submitMiscellaneousHandler = (ctx) -> {
		if(ctx.req.getSession(false) != null) {
			try{
				String body = ctx.body();
				Gson gson = new Gson();
				Miscellaneous Miscellaneous = gson.fromJson(body, Miscellaneous.class);
				ms.submitMiscellaneous(Miscellaneous);
				ctx.result("Miscellaneous was sucessfully added!");
				ctx.status(201);
			}
			catch(Exception e) {
				ctx.result("Failed to insert Miscellaneous request");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}		
	};
	public Handler updateMiscellaneousStatusHandler = ctx ->{
		if(ctx.req.getSession(false) != null) {
			try{
				String body = ctx.body();
				Gson gson = new Gson();
				Miscellaneous Miscellaneous = gson.fromJson(body, Miscellaneous.class);
				ms.updateMiscellaneousStatus(Miscellaneous);
				ctx.result("Miscellaneous Status was sucessfully updated!");
				ctx.status(200);
			}
			catch(Exception e) {
				ctx.result("There was an error while updating Miscellaneous Status");
				ctx.status(406);
			}
		}
		else {
			ctx.result("Unauthorized User");
			ctx.status(403);	
		}	
	};
}
