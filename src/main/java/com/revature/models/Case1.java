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

public class Case1 {
	
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

	public void case1() {
		
		boolean nestedWhile = true;
		while (nestedWhile) {
			System.out.println();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("~~~  Which category of reinbursement requests would you like to review?  ~~~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("1: LODGING");
			System.out.println("2: TRAVEL");
			System.out.println("3: FOOD");
			System.out.println("4: Miscellaneous");
			System.out.println("5: Exit the Program");
			System.out.println();	
			String case2 = scan.nextLine();//user input

			switch(case2) {
			
				case "1": {
					boolean doubleNested = true;
					while (doubleNested) {
						//need to get the list of employees from the repository layer
						List<Lodging> lodging = lDAO.getSingleLodging();
						//enhanced for loop to print lodging req
						for(Lodging l : lodging) {
							System.out.println(l);
						}
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~  Please Select One of the Following:  ~~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~  1 for Approve | 2 for Deny | 3 to Exit  ~~~~~~~~~~~~~~~~~");
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						String statusChange = scan.nextLine();
						switch(statusChange) {
							case "1":{
								int decision = 1;
								int lodging_id = lodging.get(0).getLodging_id();
								ls.updateLodging(decision, lodging_id);
								break;
							}
							case "2":{
								int decision = 2;
								int lodging_id = lodging.get(0).getLodging_id();
								ls.updateLodging(decision, lodging_id);
								break;
							}
							case "3":{
								System.out.println();
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println();
								doubleNested = false;
								nestedWhile = false;
								displayMenu = false;
								break;
							}
							default:{
								System.out.println();
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~  That isn't a valid input  ~~~~~~~~~~~~~~~~~");
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println();
								displayMenu = false;
								break;
							}
						}	
					}
					break;
				}
				case "2": {
					boolean doubleNested = true;
					while (doubleNested) {
					//need to get the list of employees from the repository layer
					List<Travel> travel = tDAO.getSingleTravel();
					//enhanced for loop to print out the Employees one by one
					for(Travel t : travel) {
						System.out.println(t);
					}
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~  Please Select One of the Following:  ~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~  1 for Approve | 2 for Deny | 3 to Exit  ~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					String statusChange = scan.nextLine();
					switch(statusChange) {
						case "1":{
							int decision = 1;
							int travel_id = travel.get(0).getTravel_id();
							ls.updateLodging(decision, travel_id);
							break;
						}
						case "2":{
							int decision = 2;
							int travel_id = travel.get(0).getTravel_id();
							ls.updateLodging(decision, travel_id);
							break;
						}
						case "3":{
							System.out.println();
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println();
							doubleNested = false;
							nestedWhile = false;
							displayMenu = false;
							break;
						}
						default:{
							System.out.println();
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~  That isn't a valid input  ~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println();
							displayMenu = false;
							break;
						}
					}
				}
					break;//we need a break in each case block, or else all the other calls will still run
				}
				case "3": {
					boolean doubleNested = true;
					while (doubleNested) {
					//need to get the list of employees from the repository layer
					List<Food> food = fDAO.getSingleFood();
					//enhanced for loop to print out the Employees one by one
					for(Food f : food) {
						System.out.println(f);
					}
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~  Please Select One of the Following:  ~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~  1 for Approve | 2 for Deny | 3 to Exit  ~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					String statusChange = scan.nextLine();
					switch(statusChange) {
						case "1":{
							int decision = 1;
							int food_id = food.get(0).getFood_id();
							ls.updateLodging(decision, food_id);
							break;
						}
						case "2":{
							int decision = 2;
							int food_id = food.get(0).getFood_id();
							ls.updateLodging(decision, food_id);
							break;
						}
						case "3":{
							System.out.println();
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println();
							doubleNested = false;
							nestedWhile = false;
							displayMenu = false;
							break;
						}
						default:{
							System.out.println();
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~  That isn't a valid input  ~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println();
							displayMenu = false;
							break;
						}
					}
				}
				break;//we need a break in each case block, or else all the other calls will still run
				}
				case "4": {
					boolean doubleNested = true;
					while (doubleNested) {
					//need to get the list of employees from the repository layer
					List<Miscellaneous> miscellaneous = mDAO.getSingleMiscellaneous();
					//enhanced for loop to print out the Employees one by one
					for(Miscellaneous m : miscellaneous) {
						System.out.println(m);
					}
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~  Please Select One of the Following:  ~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~  1 for Approve | 2 for Deny | 3 to Exit  ~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					String statusChange = scan.nextLine();
					switch(statusChange) {
						case "1":{
							int decision = 1;
							int misc_id = miscellaneous.get(0).getMisc_id();
							ls.updateLodging(decision, misc_id);
							break;
						}
						case "2":{
							int decision = 2;
							int misc_id = miscellaneous.get(0).getMisc_id();
							ls.updateLodging(decision, misc_id);
							break;
						}
						case "3":{
							System.out.println();
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println();
							doubleNested = false;
							nestedWhile = false;
							displayMenu = false;
							break;
						}
						default:{
							System.out.println();
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~  That isn't a valid input  ~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println();
							displayMenu = false;
							break;
						}
					}
				}
					break;//we need a break in each case block, or else all the other calls will still run
				}
				case "5":{
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~  Have a wonderful day!  ~~~~~~~~~~~~~~~~~~~~~~~~~"); 
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();
					nestedWhile = false;
					displayMenu = false;
					break;
				}
				default: {
					System.out.println();
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~  That was not a valid input!  ~~~~~~~~~~~~~~~~~~~~~~"); 
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println();							
					break;
				}
			}
			break;//we need a break in each case block, or else all the other calls will still run
		}
	}




}
