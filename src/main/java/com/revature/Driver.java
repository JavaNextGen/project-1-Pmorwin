package com.revature;


import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.FoodController;
import com.revature.controllers.LodgingController;
import com.revature.controllers.MiscellaneousController;
import com.revature.controllers.TravelController;
import com.revature.models.Menu_Employee;
import com.revature.models.Menu_Manager;
import com.revature.services.AuthService;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

@SuppressWarnings("unused")
public class Driver {

	public static void main(String[] args) throws Exception {
		EmployeeController ec = new EmployeeController();
		AuthController ac = new AuthController();
		LodgingController lc = new LodgingController();
		TravelController tc = new TravelController();
		FoodController fc = new FoodController();
		MiscellaneousController mc = new MiscellaneousController();
		AuthService as = new AuthService();
		
		try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful! :)");
		}
		catch(SQLException e) {
			System.out.println("Connection Unsuccessful! :(");
			e.printStackTrace();
		}
		

		//Instantiate a employee menu object
//		Menu_Employee e_menu = new Menu_Employee();
//		//Instantiate a manager upgrade menu object
//		Menu_Manager m_menu = new Menu_Manager();	
//		
//		
//		//Here is the actual functionality of our application---------------------------------------------
//		Boolean Starter = false;
//	
//		if (Starter) {
//		e_menu.displayMenu();
//		}
//		else {		
//		m_menu.displayMenu();
//		}

		
		
		
	
		
		
		
		
		
		
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere	
				}
			).start(3000);
	
		app.get("/", ctx -> ctx.req.getSession());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Get Requests)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Get Reimbursement Requests)");
		app.get("/lodging", lc.getLodgingHandler);
		app.get("/travel", tc.getTravelHandler);
		app.get("/food", fc.getFoodHandler);
		app.get("/miscellaneous", mc.getMiscellaneousHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Get Single Reimbursement Request)");
		app.get("/lodging_status", lc.getSingleLodgingHandler);
		app.get("/travel_status", tc.getSingleTravelHandler);
		app.get("/food_status", fc.getSingleFoodHandler);
		app.get("/miscellaneous_status", mc.getSingleMiscellaneousHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~(Get Reimbursement Requests by Employee ID)");
		app.get("/employee/{e_id}", ec.getEmployeeRequestsHandler);
		app.get("/lodging/{e_id}", lc.getEmployeeLodgingHandler);
		app.get("/travel/{e_id}", tc.getEmployeeTravelHandler);
		app.get("/food/{e_id}", fc.getEmployeeFoodHandler);
		app.get("/miscellaneous/{e_id}", mc.getEmployeeMiscellaneousHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Post Requests)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Create new Reimbursement Requests)");
		app.post("/lodging", lc.submitLodgingHandler);
		app.post("/travel", tc.submitTravelHandler);
		app.post("/food", fc.submitFoodHandler);
		app.post("/miscellaneous", mc.submitMiscellaneousHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Create a new employee)");
		app.post("/employee", ec.submitEmployeeHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Login Request)");
		app.post("/login", ac.loginHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	
		
		
		
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~(Put Requests)");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~(Update Status of Reimbursement Requests)");
		app.put("/lodging", lc.updateLodgingStatusHandler);
		app.put("/travel", tc.updateTravelStatusHandler);
		app.put("/food", fc.updateFoodStatusHandler);
		app.put("/miscellaneous", mc.updateMiscellaneousStatusHandler);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	
	
	}

}
