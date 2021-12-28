package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.FoodDAO;
import com.revature.repositories.LodgingDAO;
import com.revature.repositories.MiscellaneousDAO;
import com.revature.repositories.TravelDAO;
import com.revature.services.EmployeeService;
import com.revature.services.FoodService;
import com.revature.services.LodgingService;
import com.revature.services.MiscellaneousService;
import com.revature.services.TravelService;

public class Case3 {
	
	Scanner scan = new Scanner(System.in);
	boolean displayMenu = true;
	EmployeeDAO eDAO = new EmployeeDAO();
	FoodDAO fDAO = new FoodDAO();
	LodgingDAO lDAO = new LodgingDAO();
	TravelDAO tDAO = new TravelDAO();
	MiscellaneousDAO mDAO = new MiscellaneousDAO();
	EmployeeService eServices = new EmployeeService();
	FoodService fs = new FoodService();
	LodgingService ls = new LodgingService();
	TravelService ts = new TravelService();
	MiscellaneousService ms = new MiscellaneousService();
	Menu_Employee e_menu = new Menu_Employee();

	public void case3() {

		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~  Please Insert The Employees ID  ~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		String e_id = scan.nextLine();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("		You entered: " + e_id);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		
		
		
		
		//Need to write code to pull employee and their submitted requests
		
		
		
		
	}
}
